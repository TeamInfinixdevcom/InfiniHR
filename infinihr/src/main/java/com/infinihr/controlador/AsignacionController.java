/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */



import com.infinihr.dto.AsignacionDTO;
import com.infinihr.servicio.AsignacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignacion")
public class AsignacionController {

    @Autowired
    private AsignacionService asignacionService;

    @PostMapping
    public ResponseEntity<AsignacionDTO> crearAsignacion(@RequestBody AsignacionDTO asignacionDTO) {
        AsignacionDTO nuevo = asignacionService.crearAsignacion(asignacionDTO);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<AsignacionDTO>> listarAsignaciones() {
        List<AsignacionDTO> lista = asignacionService.listarAsignaciones();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AsignacionDTO> obtenerAsignacionPorId(@PathVariable Long id) {
        AsignacionDTO asignacion = asignacionService.obtenerAsignacionPorId(id);
        if (asignacion != null) {
            return ResponseEntity.ok(asignacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignacion(@PathVariable Long id) {
        asignacionService.eliminarAsignacion(id);
        return ResponseEntity.noContent().build();
    }
}
