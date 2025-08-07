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
import com.infinihr.entidades.Asignacion;
import com.infinihr.entidades.Proyecto;
import com.infinihr.repositorio.AsignacionRepository;
import com.infinihr.repositorio.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AsignacionServiceImpl implements AsignacionService {

    @Autowired
    private AsignacionRepository asignacionRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    // Convertir DTO a entidad
    private Asignacion toEntity(AsignacionDTO dto) {
        Asignacion entity = new Asignacion();
        entity.setId(dto.getId());
        entity.setEmpleado(dto.getEmpleado());
        entity.setFechaAsignacion(dto.getFechaAsignacion());
        entity.setRol(dto.getRol());

        // Buscar el proyecto por id
        if (dto.getProyectoId() != null) {
            Optional<Proyecto> proyectoOpt = proyectoRepository.findById(dto.getProyectoId());
            proyectoOpt.ifPresent(entity::setProyecto);
        } else {
            entity.setProyecto(null);
        }

        return entity;
    }

    // Convertir entidad a DTO
    private AsignacionDTO toDTO(Asignacion entity) {
        return new AsignacionDTO(
                entity.getId(),
                entity.getEmpleado(),
                entity.getProyecto() != null ? entity.getProyecto().getId() : null,
                entity.getFechaAsignacion(),
                entity.getRol()
        );
    }

    @Override
    public AsignacionDTO crearAsignacion(AsignacionDTO asignacionDTO) {
        Asignacion asignacion = toEntity(asignacionDTO);
        Asignacion guardada = asignacionRepository.save(asignacion);
        return toDTO(guardada);
    }

    @Override
    public List<AsignacionDTO> listarAsignaciones() {
        List<Asignacion> lista = asignacionRepository.findAll();
        return lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AsignacionDTO obtenerAsignacionPorId(Long id) {
        Optional<Asignacion> optional = asignacionRepository.findById(id);
        return optional.map(this::toDTO).orElse(null);
    }

    @Override
    public void eliminarAsignacion(Long id) {
        asignacionRepository.deleteById(id);
    }
}
