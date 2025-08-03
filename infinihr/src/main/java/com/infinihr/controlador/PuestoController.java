/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

import com.infinihr.entidades.Puesto;
import com.infinihr.repositorio.PuestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/puestos")
public class PuestoController {

    @Autowired
    private PuestoRepository puestoRepository;

    @GetMapping
    public List<Puesto> getAllPuestos() {
        return puestoRepository.findAll();
    }

    @PostMapping
    public Puesto crearPuesto(@RequestBody Puesto puesto) {
        return puestoRepository.save(puesto);
    }
}
