/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.farmacia.control;

import java.sql.Date;
import com.farmacia.conexion.Conexion;
import com.farmacia.conexion.ConexionPool;
import com.farmacia.entidad.inventario;
import com.farmacia.entidad.categoria;
import com.farmacia.entidad.presentacion;
import com.farmacia.operaciones.Operaciones;
import com.farmacia.utilerias.Tabla;
import java.io.IOException;
import java.math.BigDecimal;
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
@WebServlet(name = "Inventarios", urlPatterns = {"/Inventarios"})
public class Inventarios extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
//        HttpSession s = request.getSession();
//        List<Menu> per = (List<Menu>)s.getAttribute("Permisos");
//        List<Menu> MenuPrincipal = per.stream().filter(field -> field.getIdpadre()==0).collect(Collectors.toList());
//        request.setAttribute("MenuPrincipal", MenuPrincipal);
//        String op = request.getParameter("op");
//        if (op!=null){
//            List<Menu> PermisosAsignados = per.stream().filter(field -> field.getIdpadre()==Integer.parseInt(op)).collect(Collectors.toList());
//            request.setAttribute("PermisosAsignados", PermisosAsignados);
//        }
        String accion = request.getParameter("accion");
        if(accion==null) {
            if(request.getSession().getAttribute("resultado")!=null) {
                request.setAttribute("resultado", request.getSession().getAttribute("resultado"));
                request.getSession().removeAttribute("resultado");
            }
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                
                String sql = "";
                if(request.getParameter("txtBusqueda")!=null) {
                    sql = "select \n" +
                          "IdProducto,Nombre,precio,FORMAT(Fecha_Vencimiento, 'dd/MM/yyyy HH:mm', 'en-US') as date," + "cate.Nombre as Categoria,\n,"
                        + "esta.Nombre as Presentaciones\n"
                        + "from Inventario\n"
                        + "inner join Categoria as cate on cate.IdCategoria = Inventario.IdCategoria\n"
                        + "inner join Presentaciones as esta on esta.IdPresentacion = Inventario.IdPresentacion" +
                          " from Inventario p where Nombre like ?";
                } else {
                    sql = "select\n" +
"                          IdProducto,Nombre,precio,Fecha_Vencimiento,\n" +
"                          (select Nombre from Categoria where IdCategoria = p.IdCategoria) as Categoria,\n" +
"                            (select Nombre from Presentaciones where IdPresentacion = p.IdPresentacion) as Presentaciones\n" +
"                          from Inventario p";
                }
                String[][] inventarios = null;
                if(request.getParameter("txtBusqueda")!=null) {
                    List<Object> params = new ArrayList<>();
                    params.add("%"+request.getParameter("txtBusqueda").toString()+"%");
                    inventarios = Operaciones.consultar(sql, params);
                } else {
                    inventarios = Operaciones.consultar(sql, null);
                }

                //declaracion de cabeceras a usar en la tabla HTML
                String[] cabeceras = new String[]{
                  "ID Producto",
                  "Nombre",
                  "Precio",
                  "Fecha de Vencimiento",
                  "Categoria",
                  "Presentacion"
                 
                };
                //variable de tipo Tabla para generar la Tabla HTML
                Tabla tab = new Tabla(inventarios, //array que contiene los datos
                "50%", //ancho de la tabla px | % 
                Tabla.STYLE.TABLE01, //estilo de la tabla
                Tabla.ALIGN.CENTER,  // alineacion de la tabla
                cabeceras); //array con las cabeceras de la tabla

                //boton eliminar
                tab.setEliminable(true);
                //boton actualizar
                tab.setModificable(true); 
                //url del proyecto
                tab.setPageContext(request.getContextPath());
                //pagina encargada de eliminar
                tab.setPaginaEliminable("/Inventarios?accion=eliminar");
                //pagina encargada de actualizacion
                tab.setPaginaModificable("/Inventarios?accion=modificar");
                //pagina encargada de seleccion para operaciones
                tab.setPaginaSeleccionable("/Inventarios?accion=modificar");
                //icono para modificar y eliminar
                tab.setIconoModificable("/iconos/edit.png");
                tab.setIconoEliminable("/iconos/delete.png"); 
                //columnas seleccionables
                tab.setColumnasSeleccionables(new int[]{1});
                //pie de tabla
                tab.setPie("Resultado Productos");

                //imprime la tabla en pantalla
                String tabla01 = tab.getTabla();
                request.setAttribute("tabla", tabla01);
                request.setAttribute("valor", request.getParameter("txtBusqueda"));
                request.getRequestDispatcher("Inventario/Inventarios_consulta.jsp").forward(request, response);
            } catch(Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //request.getRequestDispatcher("paises/paises_consulta.jsp").forward(request, response);
        } else if(accion.equals("insertar")) {
            Conexion conn = new ConexionPool();
            conn.conectar();
            Operaciones.abrirConexion(conn);
            try {
                inventario p = Operaciones.get(request.getParameter("id"), new inventario());
                request.setAttribute("Inventario", p);
            } catch (Exception ex) {
                Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("Inventario/insertar_modificar.jsp").forward(request, response);
        }  else if(accion.equals("modificar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                inventario p = Operaciones.get(request.getParameter("id"), new inventario());
                categoria c = Operaciones.get(p.getIdCategoria(), new categoria());
                presentacion pr = Operaciones.get(p.getIdPresentacion(), new presentacion());
                request.setAttribute("Inventario", p);
                request.setAttribute("Categoria", c);
                request.setAttribute("Presentaciones", pr);
                Operaciones.commit();
            } catch(Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            request.getRequestDispatcher("Inventario/insertar_modificar.jsp").forward(request, response);
        }else if (accion.equals("listado_categorias")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();

                String sql = "select ca.IdCategoria, ca.Nombre from Categoria as ca inner join Categoria as c on c.IdCategoria = ca.IdCategoria;";

                String[][] categoria = Operaciones.consultar(sql, null);
                //declaracion de cabeceras a usar en la tabla HTML
                String[] cabeceras = new String[]{
                    "Id Categoria",
                    "Categoria"
                };
                //variable de tipo Tabla para generar la Tabla HTML
                Tabla tab = new Tabla(categoria, //array que contiene los datos
                        "100%", //ancho de la tabla px | %
                        Tabla.STYLE.TABLE01, //estilo de la tabla
                        Tabla.ALIGN.LEFT, // alineacion de la tabla
                        cabeceras); //array con las cabeceras de la tabla
                //url del proyecto
                tab.setPageContext(request.getContextPath());
                tab.setFilaSeleccionable(true);
                tab.setMetodoFilaSeleccionable("_Seleccionar_");
                //icono para modificar y eliminar
                tab.setIconoModificable("/iconos/edit.png");
                tab.setIconoEliminable("/iconos/delete.png");
                //columnas seleccionables
                tab.setColumnasSeleccionables(new int[]{1});
                //pie de tabla
                tab.setPie("Resultado Categorias");
                //imprime la tabla en pantalla
                String tabla01 = "No hay datos";
                if (categoria != null) {
                    tabla01 = tab.getTabla();
                }
                request.setAttribute("tabla", tabla01);
                request.getRequestDispatcher("Inventario/listado_categorias.jsp").forward(request, response);
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if (accion.equals("listado_presentacion")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();

                String sql = "select pr.IdPresentacion, pr.Nombre from Presentaciones as pr inner join Presentaciones as p on p.IdPresentacion = pr.IdPresentacion;";

                String[][] pres = Operaciones.consultar(sql, null);
                //declaracion de cabeceras a usar en la tabla HTML
                String[] cabeceras = new String[]{
                    "Id Presentacion",
                    "Presentacion"
                };
                //variable de tipo Tabla para generar la Tabla HTML
                Tabla tab = new Tabla(pres, //array que contiene los datos
                        "100%", //ancho de la tabla px | %
                        Tabla.STYLE.TABLE01, //estilo de la tabla
                        Tabla.ALIGN.LEFT, // alineacion de la tabla
                        cabeceras); //array con las cabeceras de la tabla
                //url del proyecto
                tab.setPageContext(request.getContextPath());
                tab.setFilaSeleccionable(true);
                tab.setMetodoFilaSeleccionable("_Seleccionar_");
                //icono para modificar y eliminar
                tab.setIconoModificable("/iconos/edit.png");
                tab.setIconoEliminable("/iconos/delete.png");
                //columnas seleccionables
                tab.setColumnasSeleccionables(new int[]{1});
                //pie de tabla
                tab.setPie("Resultado presentaciones");
                //imprime la tabla en pantalla
                String tabla01 = "No hay datos";
                if (pres!= null) {
                    tabla01 = tab.getTabla();
                }
                request.setAttribute("tabla", tabla01);
                request.getRequestDispatcher("Inventario/listado_presentacion.jsp").forward(request, response);
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex1);
                }
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else if (accion.equals("eliminar")) {
            try {
                Conexion conn = new ConexionPool();
                conn.conectar();
                Operaciones.abrirConexion(conn);
                Operaciones.iniciarTransaccion();
                inventario p = Operaciones.eliminar(Integer.parseInt(request.getParameter("id")), new inventario());
                if (p.getIdProducto() != 0) {
                    request.getSession().setAttribute("resultado", 1);
                } else {
                    request.getSession().setAttribute("resultado", 0);
                }
                Operaciones.commit();
            } catch (Exception ex) {
                try {
                    Operaciones.rollback();
                } catch (SQLException ex1) {
                    Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex1);
                }
                request.getSession().setAttribute("resultado", 0);
            } finally {
                try {
                    Operaciones.cerrarConexion();
                } catch (SQLException ex) {
                    Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            response.sendRedirect(request.getContextPath() + "/Inventarios");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "insertar_modificar": {
                String idProducto = request.getParameter("txtidproducto");
                String nombre = request.getParameter("txtnombre");
                String precio = request.getParameter("txtprecio");
                String fecha_vencimiento = request.getParameter("txtfecha"); 
                Date fecha = Date.valueOf(fecha_vencimiento);

                String idCategoria = request.getParameter("txtidcategoria");
                String idPresentacion = request.getParameter("txtidpresentacion");
                try {
                    Conexion conn = new ConexionPool();
                    conn.conectar();
                    Operaciones.abrirConexion(conn);
                    Operaciones.iniciarTransaccion();
                    if (Integer.parseInt(idProducto) != 0) {
                        inventario p = new inventario(Integer.parseInt(idProducto), nombre,new BigDecimal(precio),fecha,Integer.parseInt(idCategoria),Integer.parseInt(idPresentacion));
                        p = Operaciones.actualizar(p.getIdProducto(), p);
                        if (p.getIdProducto() != 0) {
                            request.getSession().setAttribute("resultado", 1);
                        } else {
                            request.getSession().setAttribute("resultado", 0);
                        }
                    } else {
                        inventario p = new inventario();
                        p.setNombre(nombre);
                        p.setPrecio(new BigDecimal(precio));
                        p.setFecha_Vencimiento(fecha);
                        p.setIdCategoria(Integer.parseInt(idCategoria));
                        p.setIdPresentacion(Integer.parseInt(idPresentacion));
                        p = Operaciones.insertar(p);
                        if (p.getIdProducto() != 0) {
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
                        Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    request.getSession().setAttribute("resultado", 2);
                } finally {
                    try {
                        Operaciones.cerrarConexion();
                    } catch (SQLException ex) {
                        Logger.getLogger(Inventarios.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                response.sendRedirect(request.getContextPath() + "/Inventarios");
                break;
            }
            case "eliminar": {
                break;
            }
        }
    }
}
