/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.dto;

/**
 *
 * @author ruben
 */

public class GeneroDTO {
    private Long id;
    private String nombre;

    // Constructores
    public GeneroDTO() {}

    public GeneroDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // toString (opcional)
    @Override
    public String toString() {
        return "GeneroDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
