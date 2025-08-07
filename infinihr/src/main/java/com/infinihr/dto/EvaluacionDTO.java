package com.infinihr.dto;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruben
 */


import java.time.LocalDate;

public class EvaluacionDTO {
    private Long id;
    private String empleado;     // Puede ser el nombre o id, según cómo lo maneje
    private String evaluador;
    private LocalDate fecha;
    private Integer puntaje;
    private String observaciones;

    // Constructores
    public EvaluacionDTO() {}

    public EvaluacionDTO(Long id, String empleado, String evaluador, LocalDate fecha, Integer puntaje, String observaciones) {
        this.id = id;
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
        return "EvaluacionDTO{" +
                "id=" + id +
                ", empleado='" + empleado + '\'' +
                ", evaluador='" + evaluador + '\'' +
                ", fecha=" + fecha +
                ", puntaje=" + puntaje +
                ", observaciones='" + observaciones + '\'' +
                '}';
    }
}
