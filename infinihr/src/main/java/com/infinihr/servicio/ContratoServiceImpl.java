/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.ContratoDTO;
import com.infinihr.entidades.Contrato;
import com.infinihr.entidades.Empleado;
import com.infinihr.entidades.Puesto;
import com.infinihr.repositorio.ContratoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoServiceImpl implements ContratoService {

    private final ContratoRepository repo;

    public ContratoServiceImpl(ContratoRepository repo) {
        this.repo = repo;
    }

    // Convierte entidad a DTO
    public ContratoDTO toDTO(Contrato entity) {
        ContratoDTO dto = new ContratoDTO();
        dto.setId(entity.getId());
        dto.setTipo(entity.getTipo());
        dto.setFechaInicio(entity.getFechaInicio());
        dto.setFechaFin(entity.getFechaFin());
        dto.setSalario(entity.getSalario());
        if(entity.getEmpleado() != null) {
            dto.setEmpleadoId(entity.getEmpleado().getId());
        }
        if(entity.getPuesto() != null) {
            dto.setPuestoId(entity.getPuesto().getId());
        }
        return dto;
    }

    // Convierte DTO a entidad
    public Contrato toEntity(ContratoDTO dto) {
        Contrato entity = new Contrato();
        entity.setId(dto.getId());
        entity.setTipo(dto.getTipo());
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaFin(dto.getFechaFin());
        entity.setSalario(dto.getSalario());
        // Solo setea relaciones si llegan los IDs
        if(dto.getEmpleadoId() != null) {
            Empleado empleado = new Empleado();
            empleado.setId(dto.getEmpleadoId());
            entity.setEmpleado(empleado);
        }
        if(dto.getPuestoId() != null) {
            Puesto puesto = new Puesto();
            puesto.setId(dto.getPuestoId());
            entity.setPuesto(puesto);
        }
        return entity;
    }

    @Override
    public List<ContratoDTO> listarTodosDTO() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public Optional<ContratoDTO> buscarPorIdDTO(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    @Override
    public ContratoDTO guardarDTO(ContratoDTO dto) {
        Contrato saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public Optional<ContratoDTO> actualizarDTO(Long id, ContratoDTO dto) {
        return repo.findById(id).map(existing -> {
            existing.setTipo(dto.getTipo());
            existing.setFechaInicio(dto.getFechaInicio());
            existing.setFechaFin(dto.getFechaFin());
            existing.setSalario(dto.getSalario());
            // Relaciones
            if(dto.getEmpleadoId() != null) {
                Empleado empleado = new Empleado();
                empleado.setId(dto.getEmpleadoId());
                existing.setEmpleado(empleado);
            }
            if(dto.getPuestoId() != null) {
                Puesto puesto = new Puesto();
                puesto.setId(dto.getPuestoId());
                existing.setPuesto(puesto);
            }
            Contrato actualizado = repo.save(existing);
            return toDTO(actualizado);
        });
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
