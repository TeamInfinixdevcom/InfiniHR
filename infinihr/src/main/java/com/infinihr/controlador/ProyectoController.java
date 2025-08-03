/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.Proyecto;
import com.infinihr.repositorio.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @GetMapping
    public List<Proyecto> getAllProyectos() {
        return proyectoRepository.findAll();
    }

    @PostMapping
    public Proyecto crearProyecto(@RequestBody Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }
}
