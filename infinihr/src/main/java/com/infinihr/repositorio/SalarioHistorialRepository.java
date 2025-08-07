/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruben
 */
package com.infinihr.repositorio;

import com.infinihr.entidades.SalarioHistorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalarioHistorialRepository extends JpaRepository<SalarioHistorial, Long> {
    // Métodos personalizados aquí si ocupa
}
