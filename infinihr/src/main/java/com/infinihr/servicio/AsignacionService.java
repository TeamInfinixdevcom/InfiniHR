/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.AsignacionDTO;
import java.util.List;

public interface AsignacionService {
    AsignacionDTO crearAsignacion(AsignacionDTO asignacionDTO);
    List<AsignacionDTO> listarAsignaciones();
    AsignacionDTO obtenerAsignacionPorId(Long id);
    void eliminarAsignacion(Long id);
}
