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

@Entity(table = "Compras")
public class Compra {
    @PrimaryKey 
    @AutoIncrement
    @FieldName(name = "IdCompra")
    private int IdCompra;
    @NotNull 
    private Date Fecha;
    @NotNull 
    private int IdProveedor;
    @NotNull 
    private int IdDetalle_Compra;
    @NotNull 
    private String idusuario;

    public Compra() {
    }

    public Compra(int IdCompra, Date Fecha, int IdProveedor, int IdDetalle_Compra, String idusuario) {
        this.IdCompra = IdCompra;
        this.Fecha = Fecha;
        this.IdProveedor = IdProveedor;
        this.IdDetalle_Compra = IdDetalle_Compra;
        this.idusuario = idusuario;
    }

    public int getIdCompra() {
        return IdCompra;
    }

    public void setIdCompra(int IdCompra) {
        this.IdCompra = IdCompra;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public int getIdProveedor() {
        return IdProveedor;
    }

    public void setIdProveedor(int IdProveedor) {
        this.IdProveedor = IdProveedor;
    }

    public int getIdDetalle_Compra() {
        return IdDetalle_Compra;
    }

    public void setIdDetalle_Compra(int IdDetalle_Compra) {
        this.IdDetalle_Compra = IdDetalle_Compra;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }


    

}
