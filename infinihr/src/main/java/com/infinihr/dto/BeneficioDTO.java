/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public class BeneficioDTO {

    private Long id;

    @NotBlank(message = "El nombre del beneficio es obligatorio")
    @Size(max = 100, message = "El nombre del beneficio debe tener máximo 100 caracteres")
    private String nombre;

    @Size(max = 255, message = "La descripción debe tener máximo 255 caracteres")
    private String descripcion;

    private LocalDate fechaOtorgado;

    @NotNull(message = "El empleado es obligatorio")
    private Long empleadoId;

    // Getters y setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFechaOtorgado() { return fechaOtorgado; }
    public void setFechaOtorgado(LocalDate fechaOtorgado) { this.fechaOtorgado = fechaOtorgado; }

    public Long getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(Long empleadoId) { this.empleadoId = empleadoId; }
}
