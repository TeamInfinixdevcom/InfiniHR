/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.BeneficioDTO;
import java.util.List;
import java.util.Optional;

public interface BeneficioService {
    List<BeneficioDTO> listarTodosDTO();
    Optional<BeneficioDTO> buscarPorIdDTO(Long id);
    BeneficioDTO guardarDTO(BeneficioDTO dto);
    Optional<BeneficioDTO> actualizarDTO(Long id, BeneficioDTO dto);
    void eliminar(Long id);
}
