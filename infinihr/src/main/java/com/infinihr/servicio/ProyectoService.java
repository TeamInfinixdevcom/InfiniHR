/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.ProyectoDTO;
import java.util.List;

public interface ProyectoService {
    ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO);
    List<ProyectoDTO> listarProyectos();
    ProyectoDTO obtenerProyectoPorId(Long id);
    void eliminarProyecto(Long id);
}
