/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.NacionalidadDTO;
import com.infinihr.entidades.Nacionalidad;
import com.infinihr.repositorio.NacionalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NacionalidadServiceImpl implements NacionalidadService {

    @Autowired
    private NacionalidadRepository nacionalidadRepository;

    // Convierte DTO a entidad
    private Nacionalidad toEntity(NacionalidadDTO dto) {
        Nacionalidad entity = new Nacionalidad();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    // Convierte entidad a DTO
    private NacionalidadDTO toDTO(Nacionalidad entity) {
        return new NacionalidadDTO(
                entity.getId(),
                entity.getNombre()
        );
    }

    @Override
    public NacionalidadDTO crearNacionalidad(NacionalidadDTO nacionalidadDTO) {
        Nacionalidad nacionalidad = toEntity(nacionalidadDTO);
        Nacionalidad guardada = nacionalidadRepository.save(nacionalidad);
        return toDTO(guardada);
    }

    @Override
    public List<NacionalidadDTO> listarNacionalidades() {
        List<Nacionalidad> lista = nacionalidadRepository.findAll();
        return lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public NacionalidadDTO obtenerNacionalidadPorId(Long id) {
        Optional<Nacionalidad> optional = nacionalidadRepository.findById(id);
        return optional.map(this::toDTO).orElse(null);
    }

    @Override
    public void eliminarNacionalidad(Long id) {
        nacionalidadRepository.deleteById(id);
    }
}
