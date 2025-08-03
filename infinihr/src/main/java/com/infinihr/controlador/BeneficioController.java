/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.Beneficio;
import com.infinihr.repositorio.BeneficioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficios")
public class BeneficioController {

    @Autowired
    private BeneficioRepository beneficioRepository;

    @GetMapping
    public List<Beneficio> getAllBeneficios() {
        return beneficioRepository.findAll();
    }

    @PostMapping
    public Beneficio crearBeneficio(@RequestBody Beneficio beneficio) {
        return beneficioRepository.save(beneficio);
    }
}

