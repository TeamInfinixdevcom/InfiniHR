/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.ParentescoDTO;
import java.util.List;
import java.util.Optional;

public interface ParentescoService {
    List<ParentescoDTO> listarTodosDTO();
    Optional<ParentescoDTO> buscarPorIdDTO(Long id);
    ParentescoDTO guardarDTO(ParentescoDTO dto);
    Optional<ParentescoDTO> actualizarDTO(Long id, ParentescoDTO dto);
    void eliminar(Long id);
}
