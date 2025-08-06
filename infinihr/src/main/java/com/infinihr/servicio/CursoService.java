/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.CursoDTO;
import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<CursoDTO> listarTodosDTO();
    Optional<CursoDTO> buscarPorIdDTO(Long id);
    CursoDTO guardarDTO(CursoDTO dto);
    Optional<CursoDTO> actualizarDTO(Long id, CursoDTO dto);
    void eliminar(Long id);
}
