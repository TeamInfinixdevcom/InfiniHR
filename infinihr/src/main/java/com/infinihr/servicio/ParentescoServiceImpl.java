/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.ParentescoDTO;
import com.infinihr.entidades.Parentesco;
import com.infinihr.entidades.Empleado;
import com.infinihr.repositorio.ParentescoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentescoServiceImpl implements ParentescoService {

    private final ParentescoRepository repo;

    public ParentescoServiceImpl(ParentescoRepository repo) {
        this.repo = repo;
    }

    // Mapeo entidad → DTO
    public ParentescoDTO toDTO(Parentesco entity) {
        ParentescoDTO dto = new ParentescoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setParentesco(entity.getParentesco());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        if (entity.getEmpleado() != null) {
            dto.setEmpleadoId(entity.getEmpleado().getId());
        }
        return dto;
    }

    // Mapeo DTO → entidad
    public Parentesco toEntity(ParentescoDTO dto) {
        Parentesco entity = new Parentesco();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setParentesco(dto.getParentesco());
        entity.setFechaNacimiento(dto.getFechaNacimiento());
        if (dto.getEmpleadoId() != null) {
            Empleado empleado = new Empleado();
            empleado.setId(dto.getEmpleadoId());
            entity.setEmpleado(empleado);
        }
        return entity;
    }

    @Override
    public List<ParentescoDTO> listarTodosDTO() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public Optional<ParentescoDTO> buscarPorIdDTO(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    @Override
    public ParentescoDTO guardarDTO(ParentescoDTO dto) {
        Parentesco saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public Optional<ParentescoDTO> actualizarDTO(Long id, ParentescoDTO dto) {
        return repo.findById(id).map(existing -> {
            existing.setNombre(dto.getNombre());
            existing.setParentesco(dto.getParentesco());
            existing.setFechaNacimiento(dto.getFechaNacimiento());
            if (dto.getEmpleadoId() != null) {
                Empleado empleado = new Empleado();
                empleado.setId(dto.getEmpleadoId());
                existing.setEmpleado(empleado);
            }
            Parentesco actualizado = repo.save(existing);
            return toDTO(actualizado);
        });
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
