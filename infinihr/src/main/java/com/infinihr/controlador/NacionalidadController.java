/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

/**
 *
 * @author ruben
 */




import com.infinihr.dto.NacionalidadDTO;
import com.infinihr.servicio.NacionalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nacionalidad")
public class NacionalidadController {

    @Autowired
    private NacionalidadService nacionalidadService;

    @PostMapping
    public ResponseEntity<NacionalidadDTO> crearNacionalidad(@RequestBody NacionalidadDTO nacionalidadDTO) {
        NacionalidadDTO nueva = nacionalidadService.crearNacionalidad(nacionalidadDTO);
        return ResponseEntity.ok(nueva);
    }

    @GetMapping
    public ResponseEntity<List<NacionalidadDTO>> listarNacionalidades() {
        List<NacionalidadDTO> lista = nacionalidadService.listarNacionalidades();
        return ResponseEntity.ok(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NacionalidadDTO> obtenerNacionalidadPorId(@PathVariable Long id) {
        NacionalidadDTO nacionalidad = nacionalidadService.obtenerNacionalidadPorId(id);
        if (nacionalidad != null) {
            return ResponseEntity.ok(nacionalidad);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarNacionalidad(@PathVariable Long id) {
        nacionalidadService.eliminarNacionalidad(id);
        return ResponseEntity.noContent().build();
    }
}
