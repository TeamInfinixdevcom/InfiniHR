/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */

import com.infinihr.dto.EvaluacionDTO;
import com.infinihr.servicio.EvaluacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/evaluacion")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @PostMapping
    public ResponseEntity<EvaluacionDTO> crearEvaluacion(@RequestBody EvaluacionDTO evaluacionDTO) {
        EvaluacionDTO nueva = evaluacionService.crearEvaluacion(evaluacionDTO);
        return ResponseEntity.ok(nueva);
    }

    @GetMapping
    public ResponseEntity<List<EvaluacionDTO>> listarEvaluaciones() {
        List<EvaluacionDTO> lista = evaluacionService.listarEvaluaciones();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EvaluacionDTO> obtenerEvaluacionPorId(@PathVariable Long id) {
        EvaluacionDTO evaluacion = evaluacionService.obtenerEvaluacionPorId(id);
        if (evaluacion != null) {
            return ResponseEntity.ok(evaluacion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEvaluacion(@PathVariable Long id) {
        evaluacionService.eliminarEvaluacion(id);
        return ResponseEntity.noContent().build();
    }
}
