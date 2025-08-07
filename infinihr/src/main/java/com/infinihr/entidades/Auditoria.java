/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.entidades;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String entidad;

    @Column(nullable = false)
    private String operacion;

    @Column(nullable = false)
    private String usuario;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Column(length = 1000)
    private String descripcion;

    // Constructores
    public Auditoria() {}

    public Auditoria(String entidad, String operacion, String usuario, LocalDateTime fechaHora, String descripcion) {
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
        return "Auditoria{" +
                "id=" + id +
                ", entidad='" + entidad + '\'' +
                ", operacion='" + operacion + '\'' +
                ", usuario='" + usuario + '\'' +
                ", fechaHora=" + fechaHora +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
