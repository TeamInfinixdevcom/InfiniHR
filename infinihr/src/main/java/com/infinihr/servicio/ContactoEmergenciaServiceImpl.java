/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.servicio;

/**
 *
 * @author ruben
 */


import com.infinihr.dto.ContactoEmergenciaDTO;
import com.infinihr.entidades.ContactoEmergencia;
import com.infinihr.repositorio.ContactoEmergenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContactoEmergenciaServiceImpl implements ContactoEmergenciaService {

    @Autowired
    private ContactoEmergenciaRepository contactoEmergenciaRepository;

    // Convertir DTO a entidad
    private ContactoEmergencia toEntity(ContactoEmergenciaDTO dto) {
        ContactoEmergencia entity = new ContactoEmergencia();
        entity.setId(dto.getId());
        entity.setEmpleado(dto.getEmpleado());
        entity.setNombreContacto(dto.getNombreContacto());
        entity.setParentesco(dto.getParentesco());
        entity.setTelefono(dto.getTelefono());
        entity.setCorreo(dto.getCorreo());
        entity.setDireccion(dto.getDireccion());
        return entity;
    }

    // Convertir entidad a DTO
    private ContactoEmergenciaDTO toDTO(ContactoEmergencia entity) {
        return new ContactoEmergenciaDTO(
                entity.getId(),
                entity.getEmpleado(),
                entity.getNombreContacto(),
                entity.getParentesco(),
                entity.getTelefono(),
                entity.getCorreo(),
                entity.getDireccion()
        );
    }

    @Override
    public ContactoEmergenciaDTO crearContactoEmergencia(ContactoEmergenciaDTO contactoEmergenciaDTO) {
        ContactoEmergencia contacto = toEntity(contactoEmergenciaDTO);
        ContactoEmergencia guardado = contactoEmergenciaRepository.save(contacto);
        return toDTO(guardado);
    }

    @Override
    public List<ContactoEmergenciaDTO> listarContactosEmergencia() {
        List<ContactoEmergencia> lista = contactoEmergenciaRepository.findAll();
        return lista.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ContactoEmergenciaDTO obtenerContactoEmergenciaPorId(Long id) {
        Optional<ContactoEmergencia> optional = contactoEmergenciaRepository.findById(id);
        return optional.map(this::toDTO).orElse(null);
    }

    @Override
    public void eliminarContactoEmergencia(Long id) {
        contactoEmergenciaRepository.deleteById(id);
    }
}
