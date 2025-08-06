/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.PuestoDTO;
import java.util.List;
import java.util.Optional;

public interface PuestoService {
    List<PuestoDTO> listarTodosDTO();
    Optional<PuestoDTO> buscarPorIdDTO(Long id);
    PuestoDTO guardarDTO(PuestoDTO dto);
    Optional<PuestoDTO> actualizarDTO(Long id, PuestoDTO dto);
    void eliminar(Long id);
}
