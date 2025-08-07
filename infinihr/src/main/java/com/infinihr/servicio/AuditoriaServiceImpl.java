/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.AuditoriaDTO;
import com.infinihr.entidades.Auditoria;
import com.infinihr.repositorio.AuditoriaRepository;
import com.infinihr.servicio.AuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AuditoriaServiceImpl implements AuditoriaService {

    @Autowired
    private AuditoriaRepository auditoriaRepository;

    // Convertir DTO a entidad
    private Auditoria toEntity(AuditoriaDTO dto) {
        Auditoria entity = new Auditoria();
        entity.setId(dto.getId());
        entity.setEntidad(dto.getEntidad());
        entity.setOperacion(dto.getOperacion());
        entity.setUsuario(dto.getUsuario());
        entity.setFechaHora(dto.getFechaHora());
        entity.setDescripcion(dto.getDescripcion());
        return entity;
    }

    // Convertir entidad a DTO
    private AuditoriaDTO toDTO(Auditoria entity) {
        return new AuditoriaDTO(
                entity.getId(),
                entity.getEntidad(),
                entity.getOperacion(),
                entity.getUsuario(),
                entity.getFechaHora(),
                entity.getDescripcion()
        );
    }

    @Override
    public AuditoriaDTO crearAuditoria(AuditoriaDTO auditoriaDTO) {
        Auditoria auditoria = toEntity(auditoriaDTO);
        Auditoria guardada = auditoriaRepository.save(auditoria);
        return toDTO(guardada);
    }

    @Override
    public List<AuditoriaDTO> listarAuditorias() {
        List<Auditoria> lista = auditoriaRepository.findAll();
        return lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuditoriaDTO obtenerAuditoriaPorId(Long id) {
        Optional<Auditoria> optional = auditoriaRepository.findById(id);
        return optional.map(this::toDTO).orElse(null);
    }

    @Override
    public void eliminarAuditoria(Long id) {
        auditoriaRepository.deleteById(id);
    }
}
