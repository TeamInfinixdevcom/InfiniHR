/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */

import com.infinihr.entidades.Familia;
import com.infinihr.repositorio.FamiliaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/familias")
public class FamiliaController {

    @Autowired
    private FamiliaRepository familiaRepository;

    @GetMapping
    public List<Familia> getAllFamilias() {
        return familiaRepository.findAll();
    }

    @PostMapping
    public Familia crearFamilia(@RequestBody Familia familia) {
        return familiaRepository.save(familia);
    }
}
