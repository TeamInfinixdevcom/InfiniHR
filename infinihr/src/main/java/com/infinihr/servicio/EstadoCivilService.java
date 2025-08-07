/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.EstadoCivilDTO;
import java.util.List;

public interface EstadoCivilService {
    EstadoCivilDTO crearEstadoCivil(EstadoCivilDTO estadoCivilDTO);
    List<EstadoCivilDTO> listarEstadosCiviles();
    EstadoCivilDTO obtenerEstadoCivilPorId(Long id);
    void eliminarEstadoCivil(Long id);
}
