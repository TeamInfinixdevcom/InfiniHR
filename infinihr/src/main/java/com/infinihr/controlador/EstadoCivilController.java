/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.EstadoCivil;
import com.infinihr.repositorio.EstadoCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estado-civil")
public class EstadoCivilController {

    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

    @GetMapping
    public List<EstadoCivil> getAll() {
        return estadoCivilRepository.findAll();
    }

    @PostMapping
    public EstadoCivil crear(@RequestBody EstadoCivil estadoCivil) {
        return estadoCivilRepository.save(estadoCivil);
    }
}
