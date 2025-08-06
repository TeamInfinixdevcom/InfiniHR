/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.UsuarioDTO;
import com.infinihr.entidades.Usuario;
import com.infinihr.repositorio.UsuarioRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository repo;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UsuarioServiceImpl(UsuarioRepository repo) {
        this.repo = repo;
    }

    // Mapeo entidad a DTO
    public UsuarioDTO toDTO(Usuario entity) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(entity.getId());
        dto.setUsername(entity.getUsername());
        dto.setRol(entity.getRol());
        // No exponer password por seguridad
        dto.setPassword(null);
        return dto;
    }

    // Mapeo DTO a entidad
    public Usuario toEntity(UsuarioDTO dto) {
        Usuario entity = new Usuario();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setRol(dto.getRol());
        // Encriptar password solo si viene (en registro)
        if (dto.getPassword() != null) {
            entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        }
        return entity;
    }

    @Override
    public UsuarioDTO registrarUsuario(UsuarioDTO dto) {
        Usuario saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public Optional<UsuarioDTO> buscarPorUsername(String username) {
        return repo.findByUsername(username).map(this::toDTO);
    }
}
