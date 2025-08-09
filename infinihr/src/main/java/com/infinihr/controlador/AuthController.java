/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.controlador;

import com.infinihr.entidades.Usuario;
import com.infinihr.repositorio.UsuarioRepository;
import com.infinihr.seguridad.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired private AuthenticationManager authManager;
    @Autowired private JwtUtil jwtUtil;

    // Solo para el endpoint de diagnóstico (no se usa en login normal)
    @Autowired private UsuarioRepository usuarioRepo;
    @Autowired private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword())
            );
            UserDetails user = (UserDetails) auth.getPrincipal();
            String token = jwtUtil.generateToken(user);
            return ResponseEntity.ok("{\"token\":\"" + token + "\"}");
        } catch (Exception e) {
            return ResponseEntity.status(401).body("{\"error\":\"Credenciales inválidas\"}");
        }
    }

    // Endpoint de diagnóstico para revisar existencia del usuario y match de contraseña
    @PostMapping("/debug-match")
    public ResponseEntity<?> debugMatch(@RequestBody LoginRequest req) {
        Optional<Usuario> userOpt = usuarioRepo.findByUsername(req.getUsername());
        if (userOpt.isEmpty()) {
            return ResponseEntity.ok("{\"exists\":false}");
        }
        Usuario user = userOpt.get();
        boolean matches = passwordEncoder.matches(req.getPassword(), user.getPassword());
        return ResponseEntity.ok("{\"exists\":true,"
                + "\"storedHash\":\"" + user.getPassword() + "\","
                + "\"matches\":" + matches + "}");
    }

    public static class LoginRequest {
        private String username;
        private String password;
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }
}
