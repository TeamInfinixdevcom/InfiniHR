/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.EstadoCivilDTO;
import com.infinihr.entidades.EstadoCivil;
import com.infinihr.repositorio.EstadoCivilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoCivilServiceImpl implements EstadoCivilService {

    @Autowired
    private EstadoCivilRepository estadoCivilRepository;

    // Convertir DTO a entidad
    private EstadoCivil toEntity(EstadoCivilDTO dto) {
        EstadoCivil entity = new EstadoCivil();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    // Convertir entidad a DTO
    private EstadoCivilDTO toDTO(EstadoCivil entity) {
        return new EstadoCivilDTO(
                entity.getId(),
                entity.getNombre()
        );
    }

    @Override
    public EstadoCivilDTO crearEstadoCivil(EstadoCivilDTO estadoCivilDTO) {
        EstadoCivil estadoCivil = toEntity(estadoCivilDTO);
        EstadoCivil guardado = estadoCivilRepository.save(estadoCivil);
        return toDTO(guardado);
    }

    @Override
    public List<EstadoCivilDTO> listarEstadosCiviles() {
        List<EstadoCivil> lista = estadoCivilRepository.findAll();
        return lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EstadoCivilDTO obtenerEstadoCivilPorId(Long id) {
        Optional<EstadoCivil> optional = estadoCivilRepository.findById(id);
        return optional.map(this::toDTO).orElse(null);
    }

    @Override
    public void eliminarEstadoCivil(Long id) {
        estadoCivilRepository.deleteById(id);
    }
}
