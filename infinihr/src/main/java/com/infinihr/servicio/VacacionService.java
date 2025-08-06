/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 package com.infinihr.servicio;

import com.infinihr.dto.VacacionDTO;
import java.util.List;
import java.util.Optional;

public interface VacacionService {
    List<VacacionDTO> listarTodosDTO();
    Optional<VacacionDTO> buscarPorIdDTO(Long id);
    VacacionDTO guardarDTO(VacacionDTO dto);
    Optional<VacacionDTO> actualizarDTO(Long id, VacacionDTO dto);
    void eliminar(Long id);
}
