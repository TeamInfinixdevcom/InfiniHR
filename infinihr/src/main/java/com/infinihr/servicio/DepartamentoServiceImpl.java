/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.DepartamentoDTO;
import com.infinihr.entidades.Departamento;
import com.infinihr.repositorio.DepartamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private final DepartamentoRepository repo;

    public DepartamentoServiceImpl(DepartamentoRepository repo) {
        this.repo = repo;
    }

    // Convierte Departamento (entidad) a DepartamentoDTO
    public DepartamentoDTO toDTO(Departamento entity) {
        DepartamentoDTO dto = new DepartamentoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        if(entity.getDepartamentoPadre() != null) {
            dto.setDepartamentoPadreId(entity.getDepartamentoPadre().getId());
        }
        return dto;
    }

    // Convierte DepartamentoDTO a Departamento (entidad)
    public Departamento toEntity(DepartamentoDTO dto) {
        Departamento entity = new Departamento();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        // Relacionar el padre solo si se envía el id
        if(dto.getDepartamentoPadreId() != null) {
            Departamento padre = new Departamento();
            padre.setId(dto.getDepartamentoPadreId());
            entity.setDepartamentoPadre(padre);
        }
        return entity;
    }

    @Override
    public List<DepartamentoDTO> listarTodosDTO() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public Optional<DepartamentoDTO> buscarPorIdDTO(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    @Override
    public DepartamentoDTO guardarDTO(DepartamentoDTO dto) {
        Departamento saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public Optional<DepartamentoDTO> actualizarDTO(Long id, DepartamentoDTO dto) {
        return repo.findById(id).map(existing -> {
            existing.setNombre(dto.getNombre());
            existing.setDescripcion(dto.getDescripcion());
            // Relacionar el padre solo si se envía el id
            if(dto.getDepartamentoPadreId() != null) {
                Departamento padre = new Departamento();
                padre.setId(dto.getDepartamentoPadreId());
                existing.setDepartamentoPadre(padre);
            } else {
                existing.setDepartamentoPadre(null);
            }
            Departamento actualizado = repo.save(existing);
            return toDTO(actualizado);
        });
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
