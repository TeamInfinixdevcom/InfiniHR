/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.EvaluacionDTO;
import java.util.List;

public interface EvaluacionService {
    EvaluacionDTO crearEvaluacion(EvaluacionDTO evaluacionDTO);
    List<EvaluacionDTO> listarEvaluaciones();
    EvaluacionDTO obtenerEvaluacionPorId(Long id);
    void eliminarEvaluacion(Long id);
}
