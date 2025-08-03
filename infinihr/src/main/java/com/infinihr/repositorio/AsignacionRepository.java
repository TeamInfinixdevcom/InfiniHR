/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.repositorio;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.Asignacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignacionRepository extends JpaRepository<Asignacion, Long> {
}
