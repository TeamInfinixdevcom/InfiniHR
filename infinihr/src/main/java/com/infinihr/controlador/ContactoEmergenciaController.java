/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */



import com.infinihr.dto.ContactoEmergenciaDTO;
import com.infinihr.servicio.ContactoEmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contacto-emergencia")
public class ContactoEmergenciaController {

    @Autowired
    private ContactoEmergenciaService contactoEmergenciaService;

    @PostMapping
    public ResponseEntity<ContactoEmergenciaDTO> crearContactoEmergencia(@RequestBody ContactoEmergenciaDTO contactoEmergenciaDTO) {
        ContactoEmergenciaDTO nuevo = contactoEmergenciaService.crearContactoEmergencia(contactoEmergenciaDTO);
        return ResponseEntity.ok(nuevo);
    }

    @GetMapping
    public ResponseEntity<List<ContactoEmergenciaDTO>> listarContactosEmergencia() {
        List<ContactoEmergenciaDTO> lista = contactoEmergenciaService.listarContactosEmergencia();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactoEmergenciaDTO> obtenerContactoEmergenciaPorId(@PathVariable Long id) {
        ContactoEmergenciaDTO contacto = contactoEmergenciaService.obtenerContactoEmergenciaPorId(id);
        if (contacto != null) {
            return ResponseEntity.ok(contacto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContactoEmergencia(@PathVariable Long id) {
        contactoEmergenciaService.eliminarContactoEmergencia(id);
        return ResponseEntity.noContent().build();
    }
}
