/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.Genero;
import com.infinihr.repositorio.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroRepository generoRepository;

    @GetMapping
    public List<Genero> getAll() {
        return generoRepository.findAll();
    }

    @PostMapping
    public Genero crear(@RequestBody Genero genero) {
        return generoRepository.save(genero);
    }
}
