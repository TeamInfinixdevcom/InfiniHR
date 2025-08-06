/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.UsuarioDTO;
import java.util.Optional;

public interface UsuarioService {
    UsuarioDTO registrarUsuario(UsuarioDTO dto);
    Optional<UsuarioDTO> buscarPorUsername(String username);
}
