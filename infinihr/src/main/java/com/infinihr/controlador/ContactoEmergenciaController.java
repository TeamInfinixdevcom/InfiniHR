/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.ContactoEmergencia;
import com.infinihr.repositorio.ContactoEmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contactos-emergencia")
public class ContactoEmergenciaController {

    @Autowired
    private ContactoEmergenciaRepository contactoEmergenciaRepository;

    @GetMapping
    public List<ContactoEmergencia> getAllContactos() {
        return contactoEmergenciaRepository.findAll();
    }

    @PostMapping
    public ContactoEmergencia crearContacto(@RequestBody ContactoEmergencia contacto) {
        return contactoEmergenciaRepository.save(contacto);
    }
}
