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

@Entity(table = "Facturas")
public class Factura {
     @PrimaryKey 
    @AutoIncrement
    @FieldName(name = "IdFactura")
    private int IdFactura;
    @NotNull 
    private double SubTotal;
    @NotNull 
    private double Total;
    @NotNull 
    private double Descuento;
    @NotNull 
    private double No_Sujeto;
    @NotNull 
    private double Iva;
    @NotNull 
    private Date Fecha;
    @NotNull 
    private String Forma_Pago;
    @NotNull 
    private int IdCliente;
    @NotNull 
    private String idusuario;
    @NotNull 
    private int IdDetalle_Factura;
    @NotNull 
    private int IdTipo_Documento;

    public Factura() {
    }

    public Factura(int IdFactura, double SubTotal, double Total, double Descuento, double No_Sujeto, double Iva, Date Fecha, String Forma_Pago, int IdCliente, String idusuario, int IdDetalle_Factura, int IdTipo_Documento) {
        this.IdFactura = IdFactura;
        this.SubTotal = SubTotal;
        this.Total = Total;
        this.Descuento = Descuento;
        this.No_Sujeto = No_Sujeto;
        this.Iva = Iva;
        this.Fecha = Fecha;
        this.Forma_Pago = Forma_Pago;
        this.IdCliente = IdCliente;
        this.idusuario = idusuario;
        this.IdDetalle_Factura = IdDetalle_Factura;
        this.IdTipo_Documento = IdTipo_Documento;
    }

    public int getIdFactura() {
        return IdFactura;
    }

    public void setIdFactura(int IdFactura) {
        this.IdFactura = IdFactura;
    }

    public double getSubTotal() {
        return SubTotal;
    }

    public void setSubTotal(double SubTotal) {
        this.SubTotal = SubTotal;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double Total) {
        this.Total = Total;
    }

    public double getDescuento() {
        return Descuento;
    }

    public void setDescuento(double Descuento) {
        this.Descuento = Descuento;
    }

    public double getNo_Sujeto() {
        return No_Sujeto;
    }

    public void setNo_Sujeto(double No_Sujeto) {
        this.No_Sujeto = No_Sujeto;
    }

    public double getIva() {
        return Iva;
    }

    public void setIva(double Iva) {
        this.Iva = Iva;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public String getForma_Pago() {
        return Forma_Pago;
    }

    public void setForma_Pago(String Forma_Pago) {
        this.Forma_Pago = Forma_Pago;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdDetalle_Factura() {
        return IdDetalle_Factura;
    }

    public void setIdDetalle_Factura(int IdDetalle_Factura) {
        this.IdDetalle_Factura = IdDetalle_Factura;
    }

    public int getIdTipo_Documento() {
        return IdTipo_Documento;
    }

    public void setIdTipo_Documento(int IdTipo_Documento) {
        this.IdTipo_Documento = IdTipo_Documento;
    }

    
    
}
