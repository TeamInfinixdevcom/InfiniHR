/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

import com.infinihr.dto.AuditoriaDTO;
import com.infinihr.servicio.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auditoria")
public class AuditoriaController {

    @Autowired
    private AuditoriaService auditoriaService;

    @PostMapping
    public ResponseEntity<AuditoriaDTO> crearAuditoria(@RequestBody AuditoriaDTO auditoriaDTO) {
        AuditoriaDTO nueva = auditoriaService.crearAuditoria(auditoriaDTO);
        return ResponseEntity.ok(nueva);
    }

    @GetMapping
    public ResponseEntity<List<AuditoriaDTO>> listarAuditorias() {
        List<AuditoriaDTO> lista = auditoriaService.listarAuditorias();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditoriaDTO> obtenerAuditoriaPorId(@PathVariable Long id) {
        AuditoriaDTO auditoria = auditoriaService.obtenerAuditoriaPorId(id);
        if (auditoria != null) {
            return ResponseEntity.ok(auditoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAuditoria(@PathVariable Long id) {
        auditoriaService.eliminarAuditoria(id);
        return ResponseEntity.noContent().build();
    }
}
