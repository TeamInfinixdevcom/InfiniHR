/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

import com.infinihr.entidades.Departamento;
import com.infinihr.repositorio.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @GetMapping
    public List<Departamento> getAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    @PostMapping
    public Departamento crearDepartamento(@RequestBody Departamento departamento) {
        return departamentoRepository.save(departamento);
    }
}
