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
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String tipo; // Ej: "pdf", "jpg", etc.

    @Lob
    @Column(name = "archivo_binario")
    private byte[] archivoBinario;
    // getters y setters

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    private Empleado empleado;

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public byte[] getArchivo() {
        return archivoBinario;
    }

    public void setArchivo(byte[] archivo) {
        this.archivoBinario = archivo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
