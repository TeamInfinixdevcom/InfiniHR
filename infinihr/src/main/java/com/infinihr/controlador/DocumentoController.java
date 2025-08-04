

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ruben
 */
package com.infinihr.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    @Autowired
    private DataSource dataSource;

    // 1) Subida vía JDBC
    @PostMapping("/subir-jdbc")
    public ResponseEntity<String> subirJdbc(
            @RequestParam("nombre") String nombre,
            @RequestParam("tipo") String tipo,
            @RequestParam("empleadoId") Long empleadoId,
            @RequestParam("archivo") MultipartFile archivo) {

        String sql = "INSERT INTO documentos(nombre, tipo, archivo_binario, empleado_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nombre);
            ps.setString(2, tipo);
            ps.setBytes(3, archivo.getBytes());
            ps.setLong(4, empleadoId);
            ps.executeUpdate();

            return ResponseEntity.ok("Documento guardado correctamente (JDBC directo).");

        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error JDBC: " + e.getMessage());
        }
    }

    // 2) Descarga vía JDBC
    @GetMapping("/descargar-jdbc/{id}")
    public ResponseEntity<byte[]> descargarJdbc(@PathVariable Long id) {
        String sql = "SELECT archivo_binario, nombre, tipo FROM documentos WHERE id = ?";
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) {
                    return ResponseEntity.notFound().build();
                }
                byte[] datos = rs.getBytes("archivo_binario");
                String nombre = rs.getString("nombre");
                String tipo = rs.getString("tipo");

                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION,
                                "attachment; filename=\"" + nombre + "\"")
                        .contentType(MediaType.parseMediaType("application/" + tipo))
                        .body(datos);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}

