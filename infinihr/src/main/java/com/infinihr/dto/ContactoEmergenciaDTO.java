/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.infinihr.dto;

/**
 *
 * @author ruben
 */


public class ContactoEmergenciaDTO {
    private Long id;
    private String empleado;
    private String nombreContacto;
    private String parentesco;
    private String telefono;
    private String correo;
    private String direccion;

    // Constructores
    public ContactoEmergenciaDTO() {}

    public ContactoEmergenciaDTO(Long id, String empleado, String nombreContacto, String parentesco, String telefono, String correo, String direccion) {
        this.id = id;
        this.empleado = empleado;
        this.nombreContacto = nombreContacto;
        this.parentesco = parentesco;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
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

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    // toString (opcional)
    @Override
    public String toString() {
        return "ContactoEmergenciaDTO{" +
                "id=" + id +
                ", empleado='" + empleado + '\'' +
                ", nombreContacto='" + nombreContacto + '\'' +
                ", parentesco='" + parentesco + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
