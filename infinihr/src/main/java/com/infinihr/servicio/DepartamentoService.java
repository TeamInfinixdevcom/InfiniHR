/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.DepartamentoDTO;
import java.util.List;
import java.util.Optional;

public interface DepartamentoService {
    List<DepartamentoDTO> listarTodosDTO();
    Optional<DepartamentoDTO> buscarPorIdDTO(Long id);
    DepartamentoDTO guardarDTO(DepartamentoDTO dto);
    Optional<DepartamentoDTO> actualizarDTO(Long id, DepartamentoDTO dto);
    void eliminar(Long id);
}
