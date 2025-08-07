/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.dto;

import java.time.LocalDate;

public class SalarioHistorialDTO {
    private Long id;
    private String empleado;        // Puede ser nombre, cédula o id según lo maneje
    private Double salario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String motivoCambio;

    // Constructores
    public SalarioHistorialDTO() {}

    public SalarioHistorialDTO(Long id, String empleado, Double salario, LocalDate fechaInicio, LocalDate fechaFin, String motivoCambio) {
        this.id = id;
        this.empleado = empleado;
        this.salario = salario;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.motivoCambio = motivoCambio;
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
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

    public String getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }

    // toString (opcional)
    @Override
    public String toString() {
        return "SalarioHistorialDTO{" +
                "id=" + id +
                ", empleado='" + empleado + '\'' +
                ", salario=" + salario +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", motivoCambio='" + motivoCambio + '\'' +
                '}';
    }
}
