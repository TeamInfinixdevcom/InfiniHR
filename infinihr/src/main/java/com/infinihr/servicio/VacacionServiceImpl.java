/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.VacacionDTO;
import com.infinihr.entidades.Vacacion;
import com.infinihr.entidades.Empleado;
import com.infinihr.repositorio.VacacionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacacionServiceImpl implements VacacionService {

    private final VacacionRepository repo;

    public VacacionServiceImpl(VacacionRepository repo) {
        this.repo = repo;
    }

    // Convierte entidad a DTO
    public VacacionDTO toDTO(Vacacion entity) {
        VacacionDTO dto = new VacacionDTO();
        dto.setId(entity.getId());
        if (entity.getEmpleado() != null) {
            dto.setEmpleadoId(entity.getEmpleado().getId());
        }
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaFin(entity.getFechaFin());
        dto.setMotivo(entity.getMotivo());
        dto.setEstado(entity.getEstado());
        return dto;
    }

    // Convierte DTO a entidad
    public Vacacion toEntity(VacacionDTO dto) {
        Vacacion entity = new Vacacion();
        entity.setId(dto.getId());
        if (dto.getEmpleadoId() != null) {
            Empleado empleado = new Empleado();
            empleado.setId(dto.getEmpleadoId());
            entity.setEmpleado(empleado);
        }
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaFin(dto.getFechaFin());
        entity.setMotivo(dto.getMotivo());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    @Override
    public List<VacacionDTO> listarTodosDTO() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public Optional<VacacionDTO> buscarPorIdDTO(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    @Override
    public VacacionDTO guardarDTO(VacacionDTO dto) {
        Vacacion saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public Optional<VacacionDTO> actualizarDTO(Long id, VacacionDTO dto) {
        return repo.findById(id).map(existing -> {
            if (dto.getEmpleadoId() != null) {
                Empleado empleado = new Empleado();
                empleado.setId(dto.getEmpleadoId());
                existing.setEmpleado(empleado);
            }
            existing.setFechaInicio(dto.getFechaInicio());
            existing.setFechaFin(dto.getFechaFin());
            existing.setMotivo(dto.getMotivo());
            existing.setEstado(dto.getEstado());
            Vacacion actualizado = repo.save(existing);
            return toDTO(actualizado);
        });
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
