/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.ContactoEmergenciaDTO;
import java.util.List;

public interface ContactoEmergenciaService {
    ContactoEmergenciaDTO crearContactoEmergencia(ContactoEmergenciaDTO contactoEmergenciaDTO);
    List<ContactoEmergenciaDTO> listarContactosEmergencia();
    ContactoEmergenciaDTO obtenerContactoEmergenciaPorId(Long id);
    void eliminarContactoEmergencia(Long id);
}
