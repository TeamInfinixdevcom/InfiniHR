/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruben
 */
package com.infinihr.controlador;

import com.infinihr.entidades.Asistencia;
import com.infinihr.repositorio.AsistenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/asistencias")
public class AsistenciaController {

    @Autowired
    private AsistenciaRepository asistenciaRepository;

    @GetMapping
    public List<Asistencia> getAllAsistencias() {
        return asistenciaRepository.findAll();
    }

    @PostMapping
    public Asistencia crearAsistencia(@RequestBody Asistencia asistencia) {
        return asistenciaRepository.save(asistencia);
    }
}
