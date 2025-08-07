/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "evaluacion")
public class Evaluacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String empleado; // Puede ser un nombre o el id de empleado, modifique si ocupa relación

    @Column(nullable = false)
    private String evaluador;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(nullable = false)
    private Integer puntaje; // Ejemplo: escala de 1 a 100, modifique si ocupa decimal

    @Column(length = 1000)
    private String observaciones;

    // Constructores
    public Evaluacion() {}

    public Evaluacion(String empleado, String evaluador, LocalDate fecha, Integer puntaje, String observaciones) {
        this.empleado = empleado;
        this.evaluador = evaluador;
        this.fecha = fecha;
        this.puntaje = puntaje;
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

    public String getEvaluador() {
        return evaluador;
    }

    public void setEvaluador(String evaluador) {
        this.evaluador = evaluador;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Integer getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(Integer puntaje) {
        this.puntaje = puntaje;
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
        return "Evaluacion{" +
                "id=" + id +
                ", empleado='" + empleado + '\'' +
                ", evaluador='" + evaluador + '\'' +
                ", fecha=" + fecha +
                ", puntaje=" + puntaje +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
