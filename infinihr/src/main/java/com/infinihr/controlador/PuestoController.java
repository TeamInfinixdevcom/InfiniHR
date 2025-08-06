/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

import com.infinihr.dto.PuestoDTO;
import com.infinihr.servicio.PuestoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/puestos")
@CrossOrigin(origins = "http://localhost:4200")
public class PuestoController {

    private final PuestoService servicio;

    public PuestoController(PuestoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<PuestoDTO> all() {
        return servicio.listarTodosDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PuestoDTO> getOne(@PathVariable Long id) {
        return servicio.buscarPorIdDTO(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PuestoDTO> create(@RequestBody @Valid PuestoDTO dto) {
        PuestoDTO guardado = servicio.guardarDTO(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(guardado.getId())
                .toUri();
        return ResponseEntity.created(location).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PuestoDTO> update(@PathVariable Long id,
                                            @RequestBody @Valid PuestoDTO dto) {
        return servicio.actualizarDTO(id, dto)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
