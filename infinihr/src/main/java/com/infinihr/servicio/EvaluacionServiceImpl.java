/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

import com.infinihr.dto.EvaluacionDTO;
import com.infinihr.entidades.Evaluacion;
import com.infinihr.repositorio.EvaluacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EvaluacionServiceImpl implements EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepository;

    // Convertir DTO a entidad
    private Evaluacion toEntity(EvaluacionDTO dto) {
        Evaluacion entity = new Evaluacion();
        entity.setId(dto.getId());
        entity.setEmpleado(dto.getEmpleado());
        entity.setEvaluador(dto.getEvaluador());
        entity.setFecha(dto.getFecha());
        entity.setPuntaje(dto.getPuntaje());
        entity.setObservaciones(dto.getObservaciones());
        return entity;
    }

    // Convertir entidad a DTO
    private EvaluacionDTO toDTO(Evaluacion entity) {
        return new EvaluacionDTO(
                entity.getId(),
                entity.getEmpleado(),
                entity.getEvaluador(),
                entity.getFecha(),
                entity.getPuntaje(),
                entity.getObservaciones()
        );
    }

    @Override
    public EvaluacionDTO crearEvaluacion(EvaluacionDTO evaluacionDTO) {
        Evaluacion evaluacion = toEntity(evaluacionDTO);
        Evaluacion guardada = evaluacionRepository.save(evaluacion);
        return toDTO(guardada);
    }

    @Override
    public List<EvaluacionDTO> listarEvaluaciones() {
        List<Evaluacion> lista = evaluacionRepository.findAll();
        return lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EvaluacionDTO obtenerEvaluacionPorId(Long id) {
        Optional<Evaluacion> optional = evaluacionRepository.findById(id);
        return optional.map(this::toDTO).orElse(null);
    }

    @Override
    public void eliminarEvaluacion(Long id) {
        evaluacionRepository.deleteById(id);
    }
}
