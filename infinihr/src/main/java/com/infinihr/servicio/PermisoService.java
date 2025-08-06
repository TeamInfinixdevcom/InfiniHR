/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.PermisoDTO;
import java.util.List;
import java.util.Optional;

public interface PermisoService {
    List<PermisoDTO> listarTodosDTO();
    Optional<PermisoDTO> buscarPorIdDTO(Long id);
    PermisoDTO guardarDTO(PermisoDTO dto);
    Optional<PermisoDTO> actualizarDTO(Long id, PermisoDTO dto);
    void eliminar(Long id);
}
