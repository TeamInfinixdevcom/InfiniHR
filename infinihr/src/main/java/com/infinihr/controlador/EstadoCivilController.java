/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */



import com.infinihr.dto.EstadoCivilDTO;
import com.infinihr.servicio.EstadoCivilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado-civil")
public class EstadoCivilController {

    @Autowired
    private EstadoCivilService estadoCivilService;

    @PostMapping
    public ResponseEntity<EstadoCivilDTO> crearEstadoCivil(@RequestBody EstadoCivilDTO estadoCivilDTO) {
        EstadoCivilDTO nuevo = estadoCivilService.crearEstadoCivil(estadoCivilDTO);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<EstadoCivilDTO>> listarEstadosCiviles() {
        List<EstadoCivilDTO> lista = estadoCivilService.listarEstadosCiviles();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoCivilDTO> obtenerEstadoCivilPorId(@PathVariable Long id) {
        EstadoCivilDTO estadoCivil = estadoCivilService.obtenerEstadoCivilPorId(id);
        if (estadoCivil != null) {
            return ResponseEntity.ok(estadoCivil);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstadoCivil(@PathVariable Long id) {
        estadoCivilService.eliminarEstadoCivil(id);
        return ResponseEntity.noContent().build();
    }
}
