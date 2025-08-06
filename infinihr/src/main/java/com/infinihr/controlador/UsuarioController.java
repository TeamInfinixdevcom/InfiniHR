/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

import com.infinihr.dto.UsuarioDTO;
import com.infinihr.servicio.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

    private final UsuarioService servicio;

    public UsuarioController(UsuarioService servicio) {
        this.servicio = servicio;
    }

    // Registro de usuario
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> register(@RequestBody @Valid UsuarioDTO dto) {
        UsuarioDTO registrado = servicio.registrarUsuario(dto);
        // Por seguridad, password viene como null
        return ResponseEntity.ok(registrado);
    }

    // Consulta por username (opcional)
    @GetMapping("/{username}")
    public ResponseEntity<UsuarioDTO> getByUsername(@PathVariable String username) {
        return servicio.buscarPorUsername(username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
