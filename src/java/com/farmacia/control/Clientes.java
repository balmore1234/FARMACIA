/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.control;

import com.farmacia.conexion.Conexion;
import com.farmacia.conexion.ConexionPool;
import com.farmacia.entidad.categoria;
import com.farmacia.entidad.cliente;
import com.farmacia.operaciones.Operaciones;
import com.farmacia.utilerias.Tabla;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ejnef
 */
@WebServlet(name = "Clientes", urlPatterns = {"/Clientes"})
public class Clientes extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// HttpSession s = request.getSession();
// List<Menu> per = (List<Menu>)s.getAttribute("Permisos");
// List<Menu> MenuPrincipal = per.stream().filter(field -> field.getIdpadre()==0).collect(Collectors.toList());
// request.setAttribute("MenuPrincipal", MenuPrincipal);
// String op = request.getParameter("op");
// if (op!=null){
// List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre()==Integer.parseInt(op)).collect(Collectors.toList());
// request.setAttribute("PermisosAsignados", PermisosAsignados);
// }
        String accion = request.getParameter("accion");
        if (accion == null) {
            if (request.getSession().getAttribute("resultado") != null) {
                request.setAttribute("resultado", request.getSession().getAttribute("resultado"));
                request.getSession().removeAttribute("resultado");
            }
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();

                String sql = "";

                if (request.getParameter("txtBusqueda") != null) {
                    sql = "select * from Clientes where Nombre like ?";
                } else {
                    sql = "select * from Clientes";
                }
                String[][] cat = null;
                if (request.getParameter("txtBusqueda") != null) {
                    List<Object> params = new ArrayList<>();
                    params.add("%" + request.getParameter("txtBusqueda").toString() + "%");

                    cat = Operaciones.consultar(sql, params);
                } else {
                    cat = Operaciones.consultar(sql, null);
                }
//declaracion de cabeceras a usar en la tabla HTML
                String[] cabeceras = new String[]{
                    "ID Cliente",
                    "Nombre Cliente",
                    "Apellido Cliente"

                };
//variable de tipo Tabla para generar la Tabla HTML
                Tabla tab = new Tabla(cat, //array que contiene los datos
                        "70%", //ancho de la tabla px | %
                        Tabla.STYLE.TABLE01, //estilo de la tabla
                        Tabla.ALIGN.CENTER, // alineacion de la tabla
                        cabeceras); //array con las cabeceras de la tabla
//boton eliminar
                tab.setEliminable(true);
//boton actualizar
                tab.setModificable(true);
//url del proyecto
                tab.setPageContext(request.getContextPath());
//pagina encargada de eliminar
                tab.setPaginaEliminable("/Clientes?accion=eliminar");
//pagina encargada de actualizacion
                tab.setPaginaModificable("/Clientes?accion=modificar");
//pagina encargada de seleccion para operaciones
                tab.setPaginaSeleccionable("/Clientes?accion=modificar");
//icono para modificar y eliminar
                tab.setIconoModificable("/iconos/edit.png");
                tab.setIconoEliminable("/iconos/delete.png");
//columnas seleccionables
                tab.setColumnasSeleccionables(new int[]{1});
//pie de tabla
                tab.setPie("Resultado clientes");
//imprime la tabla en pantalla
                String tabla01 = tab.getTabla();
                request.setAttribute("tabla", tabla01);
                request.setAttribute("valor", request.getParameter("txtBusqueda"));

                request.getRequestDispatcher("Clientes_consulta.jsp").forward(request, response);
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
//request.getRequestDispatcher("paises/paises_consulta.jsp").forward(request, response);
        } else if (accion.equals("insertar")) {
            request.getRequestDispatcher("Clientes/insertar_modificar.jsp").forward(request, response);
        } else if (accion.equals("modificar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                cliente p = Operaciones.get(Integer.parseInt(request.getParameter("id")), new cliente());
                request.setAttribute("Clientes", p);
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("Clientes/insertar_modificar.jsp").forward(request, response);
        } else if (accion.equals("eliminar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                cliente p = Operaciones.eliminar(Integer.parseInt(request.getParameter("id")), new cliente());
                if (p.getIdCliente() != 0) {
                    request.getSession().setAttribute("resultado", 1);
                } else {
                    request.getSession().setAttribute("resultado", 0);
                }
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex1);
                }
                request.getSession().setAttribute("resultado", 0);
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            response.sendRedirect(request.getContextPath() + "/Clientes");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                String IdCliente = request.getParameter("txtcliente");
                String Nombre = request.getParameter("txtnombre");
                String Apellido = request.getParameter("txtapellido");
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    if (IdCliente != null && !IdCliente.equals("")) {
                        cliente p = new cliente(Integer.parseInt(IdCliente), Nombre,Apellido);
                        p = Operaciones.actualizar(p.getIdCliente(), p);
                        if (p.getIdCliente() != 0) {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    } else {
                           cliente p = new cliente();
                        p.setNombre(Nombre);
                        p.setApellido(Apellido);
                        p = Operaciones.insertar(p);
                        if (p.getIdCliente() != 0) {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    }
                    Operaciones.commit();
                } catch (Exception ex) {
                    try {
                        Operaciones.rollback();
                    } catch (SQLException ex1) {
                        Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 2);
                } finally {
                    try {
                        Operaciones.cerrarConexion();
                    } catch (SQLException ex) {
                        Logger.getLogger(Clientes.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/Clientes");
                break;
            }
            case "eliminar": {
                break;
            }
        }
    }
}
