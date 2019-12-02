/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entidad;

import com.farmacia.anotaciones.Entity;
import com.farmacia.anotaciones.PrimaryKey;

@Entity(table = "usuario")
public class Usuario {
    @PrimaryKey
    private String idusuario;
    private String nombres;
    private String apellidos;
    private String DUI;
    private String telefono;
    private String clave;
    private int idrol;

    public Usuario() {
    }

    public Usuario(String idusuario, String nombres, String apellidos, String DUI, String telefono, String clave, int idrol) {
        this.idusuario = idusuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.DUI = DUI;
        this.telefono = telefono;
        this.clave = clave;
        this.idrol = idrol;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDUI() {
        return DUI;
    }

    public void setDUI(String DUI) {
        this.DUI = DUI;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdrol() {
        return idrol;
    }

    public void setIdrol(int idrol) {
        this.idrol = idrol;
    }

 
    
}
