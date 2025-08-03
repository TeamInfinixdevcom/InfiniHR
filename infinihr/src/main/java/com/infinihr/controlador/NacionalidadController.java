/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.Nacionalidad;
import com.infinihr.repositorio.NacionalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nacionalidades")
public class NacionalidadController {

    @Autowired
    private NacionalidadRepository nacionalidadRepository;

    @GetMapping
    public List<Nacionalidad> getAll() {
        return nacionalidadRepository.findAll();
    }

    @PostMapping
    public Nacionalidad crear(@RequestBody Nacionalidad nacionalidad) {
        return nacionalidadRepository.save(nacionalidad);
    }
}
