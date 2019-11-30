/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.reportes;

import java.io.PrintWriter;
import com.farmacia.conexion.*;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

/**
 *
 * @author Lenovo B4080
 */
@WebServlet(name = "Reporte_producto", urlPatterns = {"/Reporte_producto"})
public class Reporte_producto extends HttpServlet {
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 //Creamos la conexion
 Conexion cn = new ConexionPool();
 cn.conectar();
 Connection conexion=cn.getConexion();

 ServletContext context = request.getServletContext();

 //obtenemos el reporte (archivo .jasper) en un archivo de tipo file
 File reportFile = new File(context.getRealPath("/")+"reportes/Reporte_Productos.jasper");

 //configuramos los parametros en una varible de tipo Map
 //que como un array
 Map parameters = new HashMap();
 parameters.put("Nombre", "1");
 //para agregar mas parametro solo llame el metodo put() varias veces
 byte[] bytes = null;
 try {
 bytes = JasperRunManager.runReportToPdf(reportFile.getPath(),parameters,conexion);
 } catch (JRException ex) {
 Logger.getLogger(Reporte_producto.class.getName()).log(Level.SEVERE, null, ex);
 }
 response.setContentType("application/pdf");

 //para que el pdf se pueda ver en microsoft explorer
 //response.setHeader("Cache-Control", "cache");

 //para que aparezca el diálogo abrir/guardar
 //response.setHeader("Content-Disposition", "attachment; filename=reporte.pdf");

 response.setHeader("Content-Disposition", "inline; filename=Reporte_Productos.pdf");
 response.setContentLength(bytes.length);
 try (ServletOutputStream ouputStream = response.getOutputStream()) {
 ouputStream.write(bytes, 0, bytes.length);
 ouputStream.flush();
 }
 }
 @Override
 protected void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 processRequest(request, response);
 }
 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response)
 throws ServletException, IOException {
 processRequest(request, response);
 }
   
}
