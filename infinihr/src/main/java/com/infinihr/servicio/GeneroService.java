/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.GeneroDTO;
import java.util.List;

public interface GeneroService {
    GeneroDTO crearGenero(GeneroDTO generoDTO);
    List<GeneroDTO> listarGeneros();
    GeneroDTO obtenerGeneroPorId(Long id);
    void eliminarGenero(Long id);
}
