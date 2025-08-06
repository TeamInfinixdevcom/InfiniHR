/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.EmpleadoDTO;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<EmpleadoDTO> listarTodosDTO();
    Optional<EmpleadoDTO> buscarPorIdDTO(Long id);
    EmpleadoDTO guardarDTO(EmpleadoDTO dto);
    Optional<EmpleadoDTO> actualizarDTO(Long id, EmpleadoDTO dto);
    void eliminar(Long id);
}
