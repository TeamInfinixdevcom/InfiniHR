/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.IncapacidadDTO;
import com.infinihr.servicio.IncapacidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incapacidad")
public class IncapacidadController {

    @Autowired
    private IncapacidadService incapacidadService;

    @PostMapping
    public ResponseEntity<IncapacidadDTO> crearIncapacidad(@RequestBody IncapacidadDTO incapacidadDTO) {
        IncapacidadDTO nueva = incapacidadService.crearIncapacidad(incapacidadDTO);
        return ResponseEntity.ok(nueva);
    }

    @GetMapping
    public ResponseEntity<List<IncapacidadDTO>> listarIncapacidades() {
        List<IncapacidadDTO> lista = incapacidadService.listarIncapacidades();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IncapacidadDTO> obtenerIncapacidadPorId(@PathVariable Long id) {
        IncapacidadDTO incapacidad = incapacidadService.obtenerIncapacidadPorId(id);
        if (incapacidad != null) {
            return ResponseEntity.ok(incapacidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarIncapacidad(@PathVariable Long id) {
        incapacidadService.eliminarIncapacidad(id);
        return ResponseEntity.noContent().build();
    }
}
