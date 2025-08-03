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
@Table(name = "familias")
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    private String nombre;
    private String apellido;

    @Column(name = "parentesco_id")
    private Integer parentescoId;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;

    private String telefono;

    @Column(name = "vive_con_empleado")
    private Boolean viveConEmpleado;

    // Getters y setters...

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public Integer getParentescoId() { return parentescoId; }
    public void setParentescoId(Integer parentescoId) { this.parentescoId = parentescoId; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Boolean getViveConEmpleado() { return viveConEmpleado; }
    public void setViveConEmpleado(Boolean viveConEmpleado) { this.viveConEmpleado = viveConEmpleado; }
}
