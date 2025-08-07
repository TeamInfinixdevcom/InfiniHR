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

public class AsignacionDTO {
    private Long id;
    private String empleado;     // Puede ser nombre, cédula o id según su sistema
    private Long proyectoId;     // Solo el id del proyecto, para simplicidad en el DTO
    private LocalDate fechaAsignacion;
    private String rol;

    // Constructores
    public AsignacionDTO() {}

    public AsignacionDTO(Long id, String empleado, Long proyectoId, LocalDate fechaAsignacion, String rol) {
        this.id = id;
        this.empleado = empleado;
        this.proyectoId = proyectoId;
        this.fechaAsignacion = fechaAsignacion;
        this.rol = rol;
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

    public Long getProyectoId() {
        return proyectoId;
    }

    public void setProyectoId(Long proyectoId) {
        this.proyectoId = proyectoId;
    }

    public LocalDate getFechaAsignacion() {
        return fechaAsignacion;
    }

    public void setFechaAsignacion(LocalDate fechaAsignacion) {
        this.fechaAsignacion = fechaAsignacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    // toString (opcional)
    @Override
    public String toString() {
        return "AsignacionDTO{" +
                "id=" + id +
                ", empleado='" + empleado + '\'' +
                ", proyectoId=" + proyectoId +
                ", fechaAsignacion=" + fechaAsignacion +
                ", rol='" + rol + '\'' +
                '}';
    }
}
