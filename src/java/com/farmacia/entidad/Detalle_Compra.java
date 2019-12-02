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

@Entity(table = "Detalle_Compras")
public class Detalle_Compra {
    @PrimaryKey 
    @AutoIncrement
    @FieldName(name = "IdDetalle_Compra")
    private int IdDetalle_Compra;
    @NotNull 
    private int IdProducto;
    @NotNull 
    private int Cantidad;
    @NotNull 
    private double PrecioUnitario;
    @NotNull 
    private double Total;

    public Detalle_Compra() {
    }

    public Detalle_Compra(int IdDetalle_Compra, int IdProducto, int Cantidad, double PrecioUnitario, double Total) {
        this.IdDetalle_Compra = IdDetalle_Compra;
        this.IdProducto = IdProducto;
        this.Cantidad = Cantidad;
        this.PrecioUnitario = PrecioUnitario;
        this.Total = Total;
    }

    public int getIdDetalle_Compra() {
        return IdDetalle_Compra;
    }

    public void setIdDetalle_Compra(int IdDetalle_Compra) {
        this.IdDetalle_Compra = IdDetalle_Compra;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(double PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }
    
    
}
