/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.springframework.http.MediaType;

@RestController
@RequestMapping("/api/testblob")
public class TestBlobController {

    @Autowired
private DataSource dataSource;

// Este es el endpoint JDBC puro
@PostMapping(
    value = "/subir-jdbc",
    consumes = MediaType.MULTIPART_FORM_DATA_VALUE
)
public ResponseEntity<String> subirJdbc(@RequestParam("archivo") MultipartFile archivo) {
    String sql = "INSERT INTO test_blob (datos) VALUES (?)";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setBytes(1, archivo.getBytes());
        ps.executeUpdate();

        return ResponseEntity.ok("Archivo guardado correctamente (JDBC directo).");

    } catch (IOException ioe) {
        ioe.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error al leer el archivo: " + ioe.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Error JDBC: " + e.getMessage());
    }
}

}