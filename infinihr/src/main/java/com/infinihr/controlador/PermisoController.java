/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.Permiso;
import com.infinihr.repositorio.PermisoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/permisos")
public class PermisoController {

    @Autowired
    private PermisoRepository permisoRepository;

    @GetMapping
    public List<Permiso> getAllPermisos() {
        return permisoRepository.findAll();
    }

    @PostMapping
    public Permiso crearPermiso(@RequestBody Permiso permiso) {
        return permisoRepository.save(permiso);
    }
}
