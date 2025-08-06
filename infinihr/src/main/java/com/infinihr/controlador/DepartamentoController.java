/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

import com.infinihr.dto.DepartamentoDTO;
import com.infinihr.servicio.DepartamentoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/departamentos")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartamentoController {

    private final DepartamentoService servicio;

    public DepartamentoController(DepartamentoService servicio) {
        this.servicio = servicio;
    }

    @GetMapping
    public List<DepartamentoDTO> all() {
        return servicio.listarTodosDTO();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> getOne(@PathVariable Long id) {
        return servicio.buscarPorIdDTO(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DepartamentoDTO> create(@RequestBody @Valid DepartamentoDTO dto) {
        DepartamentoDTO guardado = servicio.guardarDTO(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(guardado.getId())
                .toUri();
        return ResponseEntity.created(location).body(guardado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartamentoDTO> update(@PathVariable Long id,
                                                  @RequestBody @Valid DepartamentoDTO dto) {
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

