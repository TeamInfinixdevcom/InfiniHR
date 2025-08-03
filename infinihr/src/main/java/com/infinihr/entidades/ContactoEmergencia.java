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

@Entity
@Table(name = "contactos_emergencia")
public class ContactoEmergencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    private String nombre;
    private String telefono;

    @Column(name = "parentesco_id")
    private Integer parentescoId; // Podrías hacerlo relación si tenés la entidad Parentesco

    // Getters y setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Integer getParentescoId() { return parentescoId; }
    public void setParentescoId(Integer parentescoId) { this.parentescoId = parentescoId; }
}
