/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.IncapacidadDTO;
import java.util.List;

public interface IncapacidadService {
    IncapacidadDTO crearIncapacidad(IncapacidadDTO incapacidadDTO);
    List<IncapacidadDTO> listarIncapacidades();
    IncapacidadDTO obtenerIncapacidadPorId(Long id);
    void eliminarIncapacidad(Long id);
}
