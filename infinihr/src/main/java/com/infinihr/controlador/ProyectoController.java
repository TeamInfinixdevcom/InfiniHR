/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.ProyectoDTO;
import com.infinihr.servicio.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoService proyectoService;

    @PostMapping
    public ResponseEntity<ProyectoDTO> crearProyecto(@RequestBody ProyectoDTO proyectoDTO) {
        ProyectoDTO nuevo = proyectoService.crearProyecto(proyectoDTO);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<ProyectoDTO>> listarProyectos() {
        List<ProyectoDTO> lista = proyectoService.listarProyectos();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProyectoDTO> obtenerProyectoPorId(@PathVariable Long id) {
        ProyectoDTO proyecto = proyectoService.obtenerProyectoPorId(id);
        if (proyecto != null) {
            return ResponseEntity.ok(proyecto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProyecto(@PathVariable Long id) {
        proyectoService.eliminarProyecto(id);
        return ResponseEntity.noContent().build();
    }
}
