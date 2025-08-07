/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.AuditoriaDTO;
import java.util.List;

public interface AuditoriaService {
    AuditoriaDTO crearAuditoria(AuditoriaDTO auditoriaDTO);
    List<AuditoriaDTO> listarAuditorias();
    AuditoriaDTO obtenerAuditoriaPorId(Long id);
    void eliminarAuditoria(Long id);
}
