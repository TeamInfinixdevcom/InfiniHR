package com.infinihr.servicio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruben
 */

import com.infinihr.dto.NacionalidadDTO;
import java.util.List;

public interface NacionalidadService {
    NacionalidadDTO crearNacionalidad(NacionalidadDTO nacionalidadDTO);
    List<NacionalidadDTO> listarNacionalidades();
    NacionalidadDTO obtenerNacionalidadPorId(Long id);
    void eliminarNacionalidad(Long id);
}
