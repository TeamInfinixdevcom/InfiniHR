/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.AsistenciaDTO;
import com.infinihr.entidades.Asistencia;
import com.infinihr.entidades.Empleado;
import com.infinihr.repositorio.AsistenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsistenciaServiceImpl implements AsistenciaService {

    private final AsistenciaRepository repo;

    public AsistenciaServiceImpl(AsistenciaRepository repo) {
        this.repo = repo;
    }

    // Convierte entidad a DTO
    public AsistenciaDTO toDTO(Asistencia entity) {
        AsistenciaDTO dto = new AsistenciaDTO();
        dto.setId(entity.getId());
        if (entity.getEmpleado() != null) {
            dto.setEmpleadoId(entity.getEmpleado().getId());
        }
        dto.setFecha(entity.getFecha());
        dto.setHoraEntrada(entity.getHoraEntrada());
        dto.setHoraSalida(entity.getHoraSalida());
        dto.setObservacion(entity.getObservacion());
        return dto;
    }

    // Convierte DTO a entidad
    public Asistencia toEntity(AsistenciaDTO dto) {
        Asistencia entity = new Asistencia();
        entity.setId(dto.getId());
        if (dto.getEmpleadoId() != null) {
            Empleado empleado = new Empleado();
            empleado.setId(dto.getEmpleadoId());
            entity.setEmpleado(empleado);
        }
        entity.setFecha(dto.getFecha());
        entity.setHoraEntrada(dto.getHoraEntrada());
        entity.setHoraSalida(dto.getHoraSalida());
        entity.setObservacion(dto.getObservacion());
        return entity;
    }

    @Override
    public List<AsistenciaDTO> listarTodosDTO() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public Optional<AsistenciaDTO> buscarPorIdDTO(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    @Override
    public AsistenciaDTO guardarDTO(AsistenciaDTO dto) {
        Asistencia saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public Optional<AsistenciaDTO> actualizarDTO(Long id, AsistenciaDTO dto) {
        return repo.findById(id).map(existing -> {
            if (dto.getEmpleadoId() != null) {
                Empleado empleado = new Empleado();
                empleado.setId(dto.getEmpleadoId());
                existing.setEmpleado(empleado);
            }
            existing.setFecha(dto.getFecha());
            existing.setHoraEntrada(dto.getHoraEntrada());
            existing.setHoraSalida(dto.getHoraSalida());
            existing.setObservacion(dto.getObservacion());
            Asistencia actualizado = repo.save(existing);
            return toDTO(actualizado);
        });
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}

