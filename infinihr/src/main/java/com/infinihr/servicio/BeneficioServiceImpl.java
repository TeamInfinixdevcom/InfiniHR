/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.BeneficioDTO;
import com.infinihr.entidades.Beneficio;
import com.infinihr.entidades.Empleado;
import com.infinihr.repositorio.BeneficioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficioServiceImpl implements BeneficioService {

    private final BeneficioRepository repo;

    public BeneficioServiceImpl(BeneficioRepository repo) {
        this.repo = repo;
    }

    // Convierte entidad a DTO
    public BeneficioDTO toDTO(Beneficio entity) {
        BeneficioDTO dto = new BeneficioDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setDescripcion(entity.getDescripcion());
        dto.setFechaOtorgado(entity.getFechaOtorgado());
        if (entity.getEmpleado() != null) {
            dto.setEmpleadoId(entity.getEmpleado().getId());
        }
        return dto;
    }

    // Convierte DTO a entidad
    public Beneficio toEntity(BeneficioDTO dto) {
        Beneficio entity = new Beneficio();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setFechaOtorgado(dto.getFechaOtorgado());
        if (dto.getEmpleadoId() != null) {
            Empleado empleado = new Empleado();
            empleado.setId(dto.getEmpleadoId());
            entity.setEmpleado(empleado);
        }
        return entity;
    }

    @Override
    public List<BeneficioDTO> listarTodosDTO() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public Optional<BeneficioDTO> buscarPorIdDTO(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    @Override
    public BeneficioDTO guardarDTO(BeneficioDTO dto) {
        Beneficio saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public Optional<BeneficioDTO> actualizarDTO(Long id, BeneficioDTO dto) {
        return repo.findById(id).map(existing -> {
            existing.setNombre(dto.getNombre());
            existing.setDescripcion(dto.getDescripcion());
            existing.setFechaOtorgado(dto.getFechaOtorgado());
            if (dto.getEmpleadoId() != null) {
                Empleado empleado = new Empleado();
                empleado.setId(dto.getEmpleadoId());
                existing.setEmpleado(empleado);
            }
            Beneficio actualizado = repo.save(existing);
            return toDTO(actualizado);
        });
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
