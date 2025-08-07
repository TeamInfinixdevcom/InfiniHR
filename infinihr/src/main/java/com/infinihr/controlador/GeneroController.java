/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */

import com.infinihr.dto.GeneroDTO;
import com.infinihr.servicio.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genero")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @PostMapping
    public ResponseEntity<GeneroDTO> crearGenero(@RequestBody GeneroDTO generoDTO) {
        GeneroDTO nuevo = generoService.crearGenero(generoDTO);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<GeneroDTO>> listarGeneros() {
        List<GeneroDTO> lista = generoService.listarGeneros();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroDTO> obtenerGeneroPorId(@PathVariable Long id) {
        GeneroDTO genero = generoService.obtenerGeneroPorId(id);
        if (genero != null) {
            return ResponseEntity.ok(genero);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarGenero(@PathVariable Long id) {
        generoService.eliminarGenero(id);
        return ResponseEntity.noContent().build();
    }
}
