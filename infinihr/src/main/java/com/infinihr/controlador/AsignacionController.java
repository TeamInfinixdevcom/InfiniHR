/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.Asignacion;
import com.infinihr.repositorio.AsignacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionController {

    @Autowired
    private AsignacionRepository asignacionRepository;

    @GetMapping
    public List<Asignacion> getAllAsignaciones() {
        return asignacionRepository.findAll();
    }

    @PostMapping
    public Asignacion crearAsignacion(@RequestBody Asignacion asignacion) {
        return asignacionRepository.save(asignacion);
    }
}
