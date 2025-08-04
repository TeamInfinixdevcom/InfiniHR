

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ruben
 */
package com.infinihr.controlador;

import com.infinihr.entidades.Documento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    @Autowired
    private DataSource dataSource;

    /**
     * Endpoint JDBC puro para subir un documento completo
     * URL: POST /api/documentos/subir-jdbc
     */
    @PostMapping(
        value    = "/subir-jdbc",
        consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public ResponseEntity<String> subirDocumentoJdbc(
            @RequestParam("nombre") String nombre,
            @RequestParam("tipo") String tipo,
            @RequestParam("empleadoId") Long empleadoId,
            @RequestParam("archivo") MultipartFile archivo
    ) {
        String sql = "INSERT INTO documentos (nombre, tipo, archivo_binario, empleado_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, tipo);
            ps.setBytes(3, archivo.getBytes());
            ps.setLong(4, empleadoId);
            ps.executeUpdate();

            return ResponseEntity.ok("Documento subido correctamente (JDBC directo).");

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

    // (Opcional) tu endpoint JPA original:
    // @PostMapping("/subir")
    // public ResponseEntity<?> subirDocumentoJPA(...) { ... }

    // @GetMapping
    // public List<Documento> listar() { ... }
}
