/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.PuestoDTO;
import com.infinihr.entidades.Puesto;
import com.infinihr.entidades.Departamento;
import com.infinihr.repositorio.PuestoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PuestoServiceImpl implements PuestoService {

    private final PuestoRepository repo;

    public PuestoServiceImpl(PuestoRepository repo) {
        this.repo = repo;
    }

    // Mapeo de entidad a DTO
    public PuestoDTO toDTO(Puesto entity) {
        PuestoDTO dto = new PuestoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setSalarioBase(entity.getSalarioBase());
        dto.setNivel(entity.getNivel());
        if (entity.getDepartamento() != null) {
            dto.setDepartamentoId(entity.getDepartamento().getId());
        }
        return dto;
    }

    // Mapeo de DTO a entidad
    public Puesto toEntity(PuestoDTO dto) {
        Puesto entity = new Puesto();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setSalarioBase(dto.getSalarioBase());
        entity.setNivel(dto.getNivel());
        // Solo setea el departamento si llega el id
        if (dto.getDepartamentoId() != null) {
            Departamento depto = new Departamento();
            depto.setId(dto.getDepartamentoId());
            entity.setDepartamento(depto);
        }
        return entity;
    }

    @Override
    public List<PuestoDTO> listarTodosDTO() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public Optional<PuestoDTO> buscarPorIdDTO(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    @Override
    public PuestoDTO guardarDTO(PuestoDTO dto) {
        Puesto saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public Optional<PuestoDTO> actualizarDTO(Long id, PuestoDTO dto) {
        return repo.findById(id).map(existing -> {
            existing.setNombre(dto.getNombre());
            existing.setDescripcion(dto.getDescripcion());
            existing.setSalarioBase(dto.getSalarioBase());
            existing.setNivel(dto.getNivel());
            // Actualizá departamento solo si viene el ID
            if (dto.getDepartamentoId() != null) {
                Departamento depto = new Departamento();
                depto.setId(dto.getDepartamentoId());
                existing.setDepartamento(depto);
            } else {
                existing.setDepartamento(null);
            }
            Puesto actualizado = repo.save(existing);
            return toDTO(actualizado);
        });
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
