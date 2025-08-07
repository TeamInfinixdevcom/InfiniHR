/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.SalarioHistorialDTO;
import java.util.List;

public interface SalarioHistorialService {
    SalarioHistorialDTO crearSalarioHistorial(SalarioHistorialDTO salarioHistorialDTO);
    List<SalarioHistorialDTO> listarSalarioHistorial();
    SalarioHistorialDTO obtenerSalarioHistorialPorId(Long id);
    void eliminarSalarioHistorial(Long id);
}
