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

@Entity(table = "Tipo_Documentos")
public class Documento {
     @PrimaryKey 
    @AutoIncrement
    @FieldName(name = "IdTipo_Documento")
    private int IdTipo_Documento;
    @NotNull 
    private String Nombre;

    public Documento() {
    }

    public Documento(int IdTipo_Documento, String Nombre) {
        this.IdTipo_Documento = IdTipo_Documento;
        this.Nombre = Nombre;
    }

    public int getIdTipo_Documento() {
        return IdTipo_Documento;
    }

    public void setIdTipo_Documento(int IdTipo_Documento) {
        this.IdTipo_Documento = IdTipo_Documento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
    
    
}
