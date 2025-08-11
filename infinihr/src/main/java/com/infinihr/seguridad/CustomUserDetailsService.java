/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.seguridad;

import com.infinhihr.repositorio.UsuarioRepository;
import com.infinihr.repositorio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomUserDetailsService implements UserDetailsService {

    public CustomUserDetailsService(com.infinhihr.repositorio.UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

  private final UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    var u = usuarioRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("No existe: " + username));

    // IMPORTANTE: devolver el hash tal cual viene de BD (NO re-encodear)
    return new User(
        u.getUsername(),
        u.getPassword(),
        List.of(new SimpleGrantedAuthority("ROLE_" + u.getRol())) // ADMIN -> ROLE_ADMIN
    );
  }
}
