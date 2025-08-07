/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.dto;

import java.time.LocalDateTime;

public class AuditoriaDTO {
    private Long id;
    private String entidad;
    private String operacion;
    private String usuario;
    private LocalDateTime fechaHora;
    private String descripcion;

    // Constructores
    public AuditoriaDTO() {}

    public AuditoriaDTO(Long id, String entidad, String operacion, String usuario, LocalDateTime fechaHora, String descripcion) {
        this.id = id;
        this.entidad = entidad;
        this.operacion = operacion;
        this.usuario = usuario;
        this.fechaHora = fechaHora;
        this.descripcion = descripcion;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntidad() {
        return entidad;
    }

    public void setEntidad(String entidad) {
        this.entidad = entidad;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    // toString (opcional)
    @Override
    public String toString() {
        return "AuditoriaDTO{" +
                "id=" + id +
                ", entidad='" + entidad + '\'' +
                ", operacion='" + operacion + '\'' +
                ", usuario='" + usuario + '\'' +
                ", fechaHora=" + fechaHora +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
