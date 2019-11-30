/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.entidad;

import com.farmacia.anotaciones.AutoIncrement;
import com.farmacia.anotaciones.Entity;
import com.farmacia.anotaciones.FieldName;
import com.farmacia.anotaciones.NotNull;
import com.farmacia.anotaciones.PrimaryKey;
import java.sql.*;

@Entity(table = "Proveedor")
public class proveedor {
     @PrimaryKey 
    @AutoIncrement
    @FieldName(name = "IdProveedor")
    private Integer IdProveedor;
    @NotNull 
    private String Nombre;
    @NotNull 
    private String Direccion;
    @NotNull 
    private String Telefono;
    @NotNull 
    private String Correo;

    public proveedor() {
    }

    public proveedor(Integer IdProveedor, String Nombre, String Direccion, String Telefono, String Correo) {
        this.IdProveedor = IdProveedor;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo = Correo;
    }

    public Integer getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(Integer IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    
}
