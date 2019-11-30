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
import java.math.BigDecimal;
import java.util.Date;


@Entity(table = "Inventario")
public class inventario {
    @PrimaryKey 
    @AutoIncrement
    @FieldName(name = "IdProducto")
    private int IdProducto;
    @NotNull 
    private String Nombre;
    @NotNull 
    private BigDecimal precio;
    @NotNull 
    private Date Fecha_Vencimiento;
    @NotNull 
    private int IdCategoria;
    @NotNull 
    private int IdPresentacion;

    public inventario() {
    }

    public inventario(int IdProducto, String Nombre, BigDecimal precio, Date Fecha_Vencimiento, int IdCategoria, int IdPresentacion) {
        this.IdProducto = IdProducto;
        this.Nombre = Nombre;
        this.precio = precio;
        this.Fecha_Vencimiento = Fecha_Vencimiento;
        this.IdCategoria = IdCategoria;
        this.IdPresentacion = IdPresentacion;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public Date getFecha_Vencimiento() {
        return Fecha_Vencimiento;
    }

    public void setFecha_Vencimiento(Date Fecha_Vencimiento) {
        this.Fecha_Vencimiento = Fecha_Vencimiento;
    }

    public int getIdCategoria() {
        return IdCategoria;
    }

    public void setIdCategoria(int IdCategoria) {
        this.IdCategoria = IdCategoria;
    }

    public int getIdPresentacion() {
        return IdPresentacion;
    }

    public void setIdPresentacion(int IdPresentacion) {
        this.IdPresentacion = IdPresentacion;
    }
    
}