/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.ProyectoDTO;
import com.infinihr.entidades.Proyecto;
import com.infinihr.repositorio.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProyectoServiceImpl implements ProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    // Convertir DTO a entidad
    private Proyecto toEntity(ProyectoDTO dto) {
        Proyecto entity = new Proyecto();
        entity.setId(dto.getId());
        entity.setNombre(dto.getNombre());
        entity.setDescripcion(dto.getDescripcion());
        entity.setFechaInicio(dto.getFechaInicio());
        entity.setFechaFin(dto.getFechaFin());
        return entity;
    }

    // Convertir entidad a DTO
    private ProyectoDTO toDTO(Proyecto entity) {
        return new ProyectoDTO(
                entity.getId(),
                entity.getNombre(),
                entity.getDescripcion(),
                entity.getFechaInicio(),
                entity.getFechaFin()
        );
    }

    @Override
    public ProyectoDTO crearProyecto(ProyectoDTO proyectoDTO) {
        Proyecto proyecto = toEntity(proyectoDTO);
        Proyecto guardado = proyectoRepository.save(proyecto);
        return toDTO(guardado);
    }

    @Override
    public List<ProyectoDTO> listarProyectos() {
        List<Proyecto> lista = proyectoRepository.findAll();
        return lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProyectoDTO obtenerProyectoPorId(Long id) {
        Optional<Proyecto> optional = proyectoRepository.findById(id);
        return optional.map(this::toDTO).orElse(null);
    }

    @Override
    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}
