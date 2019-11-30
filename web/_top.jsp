<%@page import="com.farmacia.entidad.Menu"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% HttpSession sesion = request.getSession();
    List<Menu> MenuPrincipal = (List<Menu>) sesion.getAttribute("MenuPrincipal");

    if (sesion.getAttribute("Nombre") == null || request.getSession() == null) {
        response.sendRedirect("index.jsp");
    }
    response.setHeader("Cache-control", "no-cache, no-store, must-revalidate");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" type="text/css"/>
    <link href="css/main.css" rel="stylesheet" type="text/css"/>
    <link href="css/datetimepicker.css" rel="stylesheet" type="text/css"/>
    <script src="js/datetimepicker.js" type="text/javascript"></script>
    <link href="css/tabla.css" rel="stylesheet" type="text/css"/>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmacia</title>

    </head>
    <body >
      <div class="contenedor">
        <section>
            <div class="row">
                <div class="col-sm-4">
                   
                        <img src="imagenes/logo.png" class="figure-img img-fluid rounded">
                      
                </div>
               
            </div>
        </section> 
        <section class="contenedor">
            <div class="row">
                <div class="col-sm-8">
                    <figure class="figure">
                </div>
                <div class="col-sm-4">
                    <h6>Usuario: <%= sesion.getAttribute("Nombre")%>
                        <strong>[<%= sesion.getAttribute("Usuario")%>]</strong>
                        <a href="Principal?accion=logout">Cerrar Sesion</a>
                    </h6> 
                </div>
            </div>
        </section> 
                        <div class="contenedor">
            <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
                <ul class="navbar-nav">
                    <c:forEach var="menu" items="${MenuPrincipal}">
                        <li class="nav-item active">
                            <a class="nav-link" href="${pageContext.servletContext.contextPath}${menu.url}?op=${menu.idmenu}">${menu.menu}</a>
                        </li>

                    </c:forEach>
                </ul>
            </nav>
        </div>
      </div>               
    </body>
</html>
