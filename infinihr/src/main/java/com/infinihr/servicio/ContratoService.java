/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.ContratoDTO;
import java.util.List;
import java.util.Optional;

public interface ContratoService {
    List<ContratoDTO> listarTodosDTO();
    Optional<ContratoDTO> buscarPorIdDTO(Long id);
    ContratoDTO guardarDTO(ContratoDTO dto);
    Optional<ContratoDTO> actualizarDTO(Long id, ContratoDTO dto);
    void eliminar(Long id);
}
