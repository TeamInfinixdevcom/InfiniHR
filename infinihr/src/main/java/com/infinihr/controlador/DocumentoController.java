package com.infinihr.controlador;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ruben
 */
import com.infinihr.entidades.Documento;
import com.infinihr.entidades.Empleado;
import com.infinihr.repositorio.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentoController {

    @Autowired
    private DocumentoRepository documentoRepository;

    @GetMapping
    public List<Documento> getAllDocumentos() {
        return documentoRepository.findAll();
    }

    @PostMapping("/subir")
    public Documento subirDocumento(
            @RequestParam("nombre") String nombre,
            @RequestParam("tipo") String tipo,
            @RequestParam("empleadoId") Long empleadoId,
            @RequestParam("archivo") MultipartFile archivo
    ) throws IOException {
        Documento doc = new Documento();
        doc.setNombre(nombre);
        doc.setTipo(tipo);
        doc.setArchivo(archivo.getBytes());

        // ¡Clave para bytea!
        // Asociar el documento a un empleado solo con el id
        Empleado empleado = new Empleado();
        empleado.setId(empleadoId);
        doc.setEmpleado(empleado);

        return documentoRepository.save(doc);
    }

    @GetMapping("/descargar/{id}")
    public ResponseEntity<byte[]> descargarDocumento(@PathVariable Long id) {
        Documento documento = documentoRepository.findById(id).orElse(null);
        if (documento == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + documento.getNombre() + "\"")
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(documento.getArchivo());
    }
}
