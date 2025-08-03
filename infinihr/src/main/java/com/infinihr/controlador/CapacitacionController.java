/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.Capacitacion;
import com.infinihr.repositorio.CapacitacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/capacitaciones")
public class CapacitacionController {

    @Autowired
    private CapacitacionRepository capacitacionRepository;

    @GetMapping
    public List<Capacitacion> getAllCapacitaciones() {
        return capacitacionRepository.findAll();
    }

    @PostMapping
    public Capacitacion crearCapacitacion(@RequestBody Capacitacion capacitacion) {
        return capacitacionRepository.save(capacitacion);
    }
}

