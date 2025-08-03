/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

import com.infinihr.entidades.Vacacion;
import com.infinihr.repositorio.VacacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacaciones")
public class VacacionController {

    @Autowired
    private VacacionRepository vacacionRepository;

    @GetMapping
    public List<Vacacion> getAllVacaciones() {
        return vacacionRepository.findAll();
    }

    @PostMapping
    public Vacacion crearVacacion(@RequestBody Vacacion vacacion) {
        return vacacionRepository.save(vacacion);
    }
}
