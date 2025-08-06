/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.EmpleadoDTO;
import com.infinihr.entidades.Empleado;
import com.infinihr.repositorio.EmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    private final EmpleadoRepository repo;

    public EmpleadoServiceImpl(EmpleadoRepository repo) {
        this.repo = repo;
    }

    // Mapeo de Entidad a DTO
    public EmpleadoDTO toDTO(Empleado entity) {
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setId(entity.getId());
        dto.setNombre(entity.getNombre());
        dto.setCorreo(entity.getCorreo());
        dto.setPuesto(entity.getPuesto());
        dto.setFecha_ingreso(entity.getFecha_ingreso());
        return dto;
    }

    // Mapeo de DTO a Entidad
    public Empleado toEntity(EmpleadoDTO dto) {
        Empleado entity = new Empleado();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setCorreo(dto.getCorreo());
        entity.setPuesto(dto.getPuesto());
        entity.setFecha_ingreso(dto.getFecha_ingreso());
        return entity;
    }

    @Override
    public List<EmpleadoDTO> listarTodosDTO() {
        return repo.findAll().stream().map(this::toDTO).toList();
    }

    @Override
    public Optional<EmpleadoDTO> buscarPorIdDTO(Long id) {
        return repo.findById(id).map(this::toDTO);
    }

    @Override
    public EmpleadoDTO guardarDTO(EmpleadoDTO dto) {
        Empleado saved = repo.save(toEntity(dto));
        return toDTO(saved);
    }

    @Override
    public Optional<EmpleadoDTO> actualizarDTO(Long id, EmpleadoDTO dto) {
        return repo.findById(id).map(existing -> {
            existing.setNombre(dto.getNombre());
            existing.setCorreo(dto.getCorreo());
            existing.setPuesto(dto.getPuesto());
            existing.setFecha_ingreso(dto.getFecha_ingreso());
            Empleado actualizado = repo.save(existing);
            return toDTO(actualizado);
        });
    }

    @Override
    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
