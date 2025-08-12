/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.seguridad;

import com.infinihr.entidades.Usuario;
import com.infinihr.repositorio.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UsuarioRepository usuarioRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuario u = usuarioRepository.findByUsername(username)
        .orElseThrow(() -> new UsernameNotFoundException("No existe: " + username));

    // Devolver el hash tal cual viene de BD (NO re-encodear)
    return new User(
        u.getUsername(),
        u.getPassword(),
        List.of(new SimpleGrantedAuthority("ROLE_" + u.getRol())) // ADMIN -> ROLE_ADMIN
    );
  }
}
