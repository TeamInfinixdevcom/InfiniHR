/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String tipo;

    @Lob
    @Column(
        name = "archivo_binario",
        nullable = false,
        columnDefinition = "bytea"
    )
    private byte[] archivoBinario;

    @ManyToOne
    @JoinColumn(name = "empleado_id", nullable = false)
    private Empleado empleado;

    // --- Getters y Setters ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public byte[] getArchivoBinario() { return archivoBinario; }
    public void setArchivoBinario(byte[] archivoBinario) {
        this.archivoBinario = archivoBinario;
    }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Documento{" +
            "id=" + id +
            ", nombre='" + nombre + '\'' +
            ", tipo='" + tipo + '\'' +
            ", archivoBinario=" +
                (archivoBinario != null ? archivoBinario.length + " bytes" : "null") +
            ", empleado=" + (empleado != null ? empleado.getId() : "null") +
            '}';
    }
}

