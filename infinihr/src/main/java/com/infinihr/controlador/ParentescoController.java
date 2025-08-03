/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.Parentesco;
import com.infinihr.repositorio.ParentescoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/parentescos")
public class ParentescoController {

    @Autowired
    private ParentescoRepository parentescoRepository;

    @GetMapping
    public List<Parentesco> getAll() {
        return parentescoRepository.findAll();
    }

    @PostMapping
    public Parentesco crear(@RequestBody Parentesco parentesco) {
        return parentescoRepository.save(parentesco);
    }
}
