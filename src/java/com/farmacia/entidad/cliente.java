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

@Entity(table = "Clientes")
public class cliente {
    @PrimaryKey 
    @AutoIncrement
    @FieldName(name = "IdCliente")
    private int IdCliente;
    @NotNull 
    private String Nombre;
    @NotNull 
    private String Apellido;

    public cliente() {
    }

    public cliente(int IdCliente, String Nombre, String Apellido) {
        this.IdCliente = IdCliente;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }  
    
}
