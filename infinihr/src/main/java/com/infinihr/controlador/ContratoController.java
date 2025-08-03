/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

import com.infinihr.entidades.Contrato;
import com.infinihr.repositorio.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoRepository contratoRepository;

    @GetMapping
    public List<Contrato> getAllContratos() {
        return contratoRepository.findAll();
    }

    @PostMapping
    public Contrato crearContrato(@RequestBody Contrato contrato) {
        return contratoRepository.save(contrato);
    }
}

