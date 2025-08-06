/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.PermisoDTO;
import com.infinihr.entidades.Permiso;
import com.infinihr.entidades.Empleado;
import com.infinihr.repositorio.PermisoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PermisoServiceImpl implements PermisoService {

    private final PermisoRepository repo;

    public PermisoServiceImpl(PermisoRepository repo) {
        this.repo = repo;
    }

    // Convierte entidad a DTO
    public PermisoDTO toDTO(Permiso entity) {
        PermisoDTO dto = new PermisoDTO();
        dto.setId(entity.getId());
        if (entity.getEmpleado() != null) {
            dto.setEmpleadoId(entity.getEmpleado().getId());
        }
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaFin(entity.getFechaFin());
        dto.setTipo(entity.getTipo());
        dto.setMotivo(entity.getMotivo());
        dto.setEstado(entity.getEstado());
        return dto;
    }

    // Convierte DTO a entidad
    public Permiso toEntity(PermisoDTO dto) {
        Permiso entity = new Permiso();
        entity.setId(dto.getId());
        if (dto.getEmpleadoId() != null) {
            Empleado empleado = new Empleado();
            empleado.setId(dto.getEmpleadoId());
            entity.setEmpleado(empleado);
        }
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaFin(dto.getFechaFin());
        entity.setTipo(dto.getTipo());
        entity.setMotivo(dto.getMotivo());
        entity.setEstado(dto.getEstado());
        return entity;
    }

    @Override
    public List<PermisoDTO> listarTodosDTO() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public Optional<PermisoDTO> buscarPorIdDTO(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    @Override
    public PermisoDTO guardarDTO(PermisoDTO dto) {
        Permiso saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public Optional<PermisoDTO> actualizarDTO(Long id, PermisoDTO dto) {
        return repo.findById(id).map(existing -> {
            if (dto.getEmpleadoId() != null) {
                Empleado empleado = new Empleado();
                empleado.setId(dto.getEmpleadoId());
                existing.setEmpleado(empleado);
            }
            existing.setFechaInicio(dto.getFechaInicio());
            existing.setFechaFin(dto.getFechaFin());
            existing.setTipo(dto.getTipo());
            existing.setMotivo(dto.getMotivo());
            existing.setEstado(dto.getEstado());
            Permiso actualizado = repo.save(existing);
            return toDTO(actualizado);
        });
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
