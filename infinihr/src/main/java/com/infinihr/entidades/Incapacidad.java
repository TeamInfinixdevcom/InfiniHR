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
import java.time.LocalDate;

@Entity
@Table(name = "incapacidad")
public class Incapacidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String empleado; // Puede ser nombre, cédula o id de empleado, modifíquelo si ocupa relación

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(nullable = false)
    private String tipo; // Ejemplo: "Enfermedad", "Accidente", etc.

    @Column(length = 1000)
    private String observaciones;

    // Constructores
    public Incapacidad() {}

    public Incapacidad(String empleado, LocalDate fechaInicio, LocalDate fechaFin, String tipo, String observaciones) {
        this.empleado = empleado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.tipo = tipo;
        this.observaciones = observaciones;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    // toString (opcional)
    @Override
    public String toString() {
        return "Incapacidad{" +
                "id=" + id +
                ", empleado='" + empleado + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", tipo='" + tipo + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
