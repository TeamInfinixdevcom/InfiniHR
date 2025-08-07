/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.entidades;

/**
 *
 * @author ruben
 */



import jakarta.persistence.*;

@Entity
@Table(name = "nacionalidad")
public class Nacionalidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nombre;

    // Constructores
    public Nacionalidad() {}

    public Nacionalidad(String nombre) {
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
        return "Nacionalidad{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
