/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.repositorio;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.Incapacidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncapacidadRepository extends JpaRepository<Incapacidad, Long> {
    // Puede agregar métodos personalizados aquí si ocupa
}
