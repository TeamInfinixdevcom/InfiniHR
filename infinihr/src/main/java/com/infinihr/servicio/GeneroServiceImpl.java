/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.GeneroDTO;
import com.infinihr.entidades.Genero;
import com.infinihr.repositorio.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GeneroServiceImpl implements GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    // Convertir DTO a entidad
    private Genero toEntity(GeneroDTO dto) {
        Genero entity = new Genero();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        return entity;
    }

    // Convertir entidad a DTO
    private GeneroDTO toDTO(Genero entity) {
        return new GeneroDTO(
                entity.getId(),
                entity.getNombre()
        );
    }

    @Override
    public GeneroDTO crearGenero(GeneroDTO generoDTO) {
        Genero genero = toEntity(generoDTO);
        Genero guardado = generoRepository.save(genero);
        return toDTO(guardado);
    }

    @Override
    public List<GeneroDTO> listarGeneros() {
        List<Genero> lista = generoRepository.findAll();
        return lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GeneroDTO obtenerGeneroPorId(Long id) {
        Optional<Genero> optional = generoRepository.findById(id);
        return optional.map(this::toDTO).orElse(null);
    }

    @Override
    public void eliminarGenero(Long id) {
        generoRepository.deleteById(id);
    }
}
