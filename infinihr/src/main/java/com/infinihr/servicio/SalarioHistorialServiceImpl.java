/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.SalarioHistorialDTO;
import com.infinihr.entidades.SalarioHistorial;
import com.infinihr.repositorio.SalarioHistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SalarioHistorialServiceImpl implements SalarioHistorialService {

    @Autowired
    private SalarioHistorialRepository salarioHistorialRepository;

    // Convertir DTO a entidad
    private SalarioHistorial toEntity(SalarioHistorialDTO dto) {
        SalarioHistorial entity = new SalarioHistorial();
        entity.setId(dto.getId());
        entity.setEmpleado(dto.getEmpleado());
        entity.setSalario(dto.getSalario());
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaFin(dto.getFechaFin());
        entity.setMotivoCambio(dto.getMotivoCambio());
        return entity;
    }

    // Convertir entidad a DTO
    private SalarioHistorialDTO toDTO(SalarioHistorial entity) {
        return new SalarioHistorialDTO(
                entity.getId(),
                entity.getEmpleado(),
                entity.getSalario(),
                entity.getFechaInicio(),
                entity.getFechaFin(),
                entity.getMotivoCambio()
        );
    }

    @Override
    public SalarioHistorialDTO crearSalarioHistorial(SalarioHistorialDTO salarioHistorialDTO) {
        SalarioHistorial salarioHistorial = toEntity(salarioHistorialDTO);
        SalarioHistorial guardado = salarioHistorialRepository.save(salarioHistorial);
        return toDTO(guardado);
    }

    @Override
    public List<SalarioHistorialDTO> listarSalarioHistorial() {
        List<SalarioHistorial> lista = salarioHistorialRepository.findAll();
        return lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SalarioHistorialDTO obtenerSalarioHistorialPorId(Long id) {
        Optional<SalarioHistorial> optional = salarioHistorialRepository.findById(id);
        return optional.map(this::toDTO).orElse(null);
    }

    @Override
    public void eliminarSalarioHistorial(Long id) {
        salarioHistorialRepository.deleteById(id);
    }
}
