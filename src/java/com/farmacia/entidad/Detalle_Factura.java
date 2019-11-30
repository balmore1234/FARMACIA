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

@Entity(table = "Detalle_Facturas")
public class Detalle_Factura {
    @PrimaryKey 
    @AutoIncrement
    @FieldName(name = "IdDetalle_Factura")
    private int IdDetalle_Factura;
    @NotNull 
    private int IdProducto;
    @NotNull 
    private int IdCantidad;
    @NotNull 
    private double Precio_Venta;

    public Detalle_Factura() {
    }

    public Detalle_Factura(int IdDetalle_Factura, int IdProducto, int IdCantidad, double Precio_Venta) {
        this.IdDetalle_Factura = IdDetalle_Factura;
        this.IdProducto = IdProducto;
        this.IdCantidad = IdCantidad;
        this.Precio_Venta = Precio_Venta;
    }

    public int getIdDetalle_Factura() {
        return IdDetalle_Factura;
    }

    public void setIdDetalle_Factura(int IdDetalle_Factura) {
        this.IdDetalle_Factura = IdDetalle_Factura;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getIdCantidad() {
        return IdCantidad;
    }

    public void setIdCantidad(int IdCantidad) {
        this.IdCantidad = IdCantidad;
    }

    public double getPrecio_Venta() {
        return Precio_Venta;
    }

    public void setPrecio_Venta(double Precio_Venta) {
        this.Precio_Venta = Precio_Venta;
    }
   
    
    
}
