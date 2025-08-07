/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.dto;

/**
 *
 * @author ruben
 */


import java.time.LocalDate;

public class IncapacidadDTO {
    private Long id;
    private String empleado;        // Puede ser nombre o id según cómo lo maneje
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String tipo;
    private String observaciones;

    // Constructores
    public IncapacidadDTO() {}

    public IncapacidadDTO(Long id, String empleado, LocalDate fechaInicio, LocalDate fechaFin, String tipo, String observaciones) {
        this.id = id;
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
        return "IncapacidadDTO{" +
                "id=" + id +
                ", empleado='" + empleado + '\'' +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", tipo='" + tipo + '\'' +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
