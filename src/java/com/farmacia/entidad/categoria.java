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

@Entity(table = "Categoria")
public class categoria {
    @PrimaryKey 
    @AutoIncrement
    @FieldName(name = "IdCategoria")
    private int IdCategoria;
    @NotNull 
    private String Nombre;
    
    public categoria(){
        
    }
    
    
      public categoria(int IdCategoria, String Nombre) {
        this.IdCategoria = IdCategoria;
        this.Nombre = Nombre;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    
}
