
package com.infinihr.controlador;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@Validated
public class AuthController {

    private final AuthenticationManager authenticationManager;

    // Con Basic Auth este endpoint es opcional.
    // Sirve para probar usuario/clave y responder 200/401 sin emitir JWT.
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@Valid @RequestBody LoginRequest request) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                    request.getUsername(), request.getPassword()
                )
            );
            log.info("Autenticación exitosa para: {}", request.getUsername());
            return ResponseEntity.ok(Map.of("status", "ok", "message", "Credenciales válidas"));
        } catch (BadCredentialsException e) {
            log.warn("Credenciales inválidas para: {}", request.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Credenciales inválidas"));
        } catch (DisabledException e) {
            log.warn("Cuenta deshabilitada: {}", request.getUsername());
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("error", "Cuenta deshabilitada"));
        } catch (LockedException e) {
            log.warn("Cuenta bloqueada: {}", request.getUsername());
            return ResponseEntity.status(HttpStatus.FORBIDDEN)
                    .body(Map.of("error", "Cuenta bloqueada"));
        } catch (Exception e) {
            log.error("Error de autenticación", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Error interno"));
        }
    }

    @Data
    public static class LoginRequest {
        @NotBlank(message = "Username es requerido")
        private String username;

        @NotBlank(message = "Password es requerido")
        private String password;
        // NO agregue getters “manuales” que lancen excepciones; Lombok @Data los genera bien.
    }
}
