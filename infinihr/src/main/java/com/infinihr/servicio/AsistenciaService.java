/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.AsistenciaDTO;
import java.util.List;
import java.util.Optional;

public interface AsistenciaService {
    List<AsistenciaDTO> listarTodosDTO();
    Optional<AsistenciaDTO> buscarPorIdDTO(Long id);
    AsistenciaDTO guardarDTO(AsistenciaDTO dto);
    Optional<AsistenciaDTO> actualizarDTO(Long id, AsistenciaDTO dto);
    void eliminar(Long id);
}
