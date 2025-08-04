/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.repositorio;

import com.infinihr.entidades.Documento;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository para la entidad Documento.
 * Proporciona métodos CRUD y consultas personalizadas.
 */
@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    /**
     * Devuelve una página de documentos de un empleado específico.
     *
     * @param empleadoId ID del empleado cuyos documentos queremos paginar.
     * @param pageable   Parámetros de paginación (tamaño de página, orden, etc.).
     * @return Página de documentos del empleado.
     */
    Page<Documento> findByEmpleadoId(Long empleadoId, Pageable pageable);

    /**
     * Devuelve todos los documentos de un empleado sin paginar.
     *
     * @param empleadoId ID del empleado.
     * @return Lista de documentos del empleado.
     */
    List<Documento> findByEmpleadoId(Long empleadoId);

    /**
     * Devuelve todos los documentos cuyo tipo coincide exactamente.
     *
     * @param tipo Tipo de documento (ej. "pdf", "jpg").
     * @return Lista de documentos de ese tipo.
     */
    List<Documento> findByTipo(String tipo);

    /**
     * Búsqueda por nombre parcial, ignorando mayúsculas/minúsculas.
     *
     * @param parteNombre Subcadena a buscar en el nombre del archivo.
     * @return Lista de documentos cuyo nombre contenga la subcadena.
     */
    List<Documento> findByNombreContainingIgnoreCase(String parteNombre);
}
