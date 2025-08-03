/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.repositorio;

/**
 *
 * @author ruben
 */


import com.infinihr.entidades.ContactoEmergencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactoEmergenciaRepository extends JpaRepository<ContactoEmergencia, Long> {
}
