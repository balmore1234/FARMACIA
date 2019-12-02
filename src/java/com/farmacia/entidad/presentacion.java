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

@Entity(table = "Presentaciones")
public class presentacion {
    @PrimaryKey 
    @AutoIncrement
    @FieldName(name = "IdPresentacion")
    private int IdPresentacion;
    @NotNull 
    private String Nombre;

    public presentacion() {
    }

    public presentacion(int IdPresentacion, String Nombre) {
        this.IdPresentacion = IdPresentacion;
        this.Nombre = Nombre;
    }

    public Integer getIdPresentacion() {
        return IdPresentacion;
    }

    public void setIdPresentacion(int IdPresentacion) {
        this.IdPresentacion = IdPresentacion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    
}

