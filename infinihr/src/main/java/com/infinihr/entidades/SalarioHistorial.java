/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.entidades;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "salario_historial")
public class SalarioHistorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String empleado; // Puede ser el nombre, cédula o id. Cámbielo si ocupa relación

    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false)
    private LocalDate fechaInicio;

    @Column(nullable = false)
    private LocalDate fechaFin;

    @Column(length = 1000)
    private String motivoCambio;

    // Constructores
    public SalarioHistorial() {}

    public SalarioHistorial(String empleado, Double salario, LocalDate fechaInicio, LocalDate fechaFin, String motivoCambio) {
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
        return "SalarioHistorial{" +
                "id=" + id +
                ", empleado='" + empleado + '\'' +
                ", salario=" + salario +
                ", fechaInicio=" + fechaInicio +
                ", fechaFin=" + fechaFin +
                ", motivoCambio='" + motivoCambio + '\'' +
                '}';
    }
}
