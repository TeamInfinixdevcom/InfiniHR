/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.IncapacidadDTO;
import com.infinihr.entidades.Incapacidad;
import com.infinihr.repositorio.IncapacidadRepository;
import com.infinihr.servicio.IncapacidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class IncapacidadServiceImpl implements IncapacidadService {

    @Autowired
    private IncapacidadRepository incapacidadRepository;

    // Convertir DTO a entidad
    private Incapacidad toEntity(IncapacidadDTO dto) {
        Incapacidad entity = new Incapacidad();
        entity.setId(dto.getId());
        entity.setEmpleado(dto.getEmpleado());
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaFin(dto.getFechaFin());
        entity.setTipo(dto.getTipo());
        entity.setObservaciones(dto.getObservaciones());
        return entity;
    }

    // Convertir entidad a DTO
    private IncapacidadDTO toDTO(Incapacidad entity) {
        return new IncapacidadDTO(
                entity.getId(),
                entity.getEmpleado(),
                entity.getFechaInicio(),
                entity.getFechaFin(),
                entity.getTipo(),
                entity.getObservaciones()
        );
    }

    @Override
    public IncapacidadDTO crearIncapacidad(IncapacidadDTO incapacidadDTO) {
        Incapacidad incapacidad = toEntity(incapacidadDTO);
        Incapacidad guardada = incapacidadRepository.save(incapacidad);
        return toDTO(guardada);
    }

    @Override
    public List<IncapacidadDTO> listarIncapacidades() {
        List<Incapacidad> lista = incapacidadRepository.findAll();
        return lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public IncapacidadDTO obtenerIncapacidadPorId(Long id) {
        Optional<Incapacidad> optional = incapacidadRepository.findById(id);
        return optional.map(this::toDTO).orElse(null);
    }

    @Override
    public void eliminarIncapacidad(Long id) {
        incapacidadRepository.deleteById(id);
    }
}
