<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Progma", "no-cache");
    response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<html>
    <head>
        <title>Farmacia Project</title>
        <link rel="stylesheet" type="text/css" href="css/reset.css"/>
        <link rel="stylesheet" type="text/css" href="css/main.css" media="screen"/>
         <link href="css/logincss.css" rel="stylesheet" type="text/css"/>
         <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
        
    <body>
        <br/><br/><br/>
        <div id="header">
           <br/>
            <center>
                <c:if test="${error!=null}">
                    <c:if test="${error==2}">
                        <p><strong class="alert alert-danger alert-dismissible fade show">Usuario y/o contraseña incorrecta</strong></p>
                        
                    </c:if>
                    
                </c:if>
            </center>
            
            <form name="main" action="Login?accion=login" method="POST">
                
                <div class="login-box"> 
                    <br/><br/><br/>
            <img class="avatar" src="imagenes/Login.png" alt="logo de fast">
    
                <!--usuario -->
                <label for="username">Usuario</label>
                <input type="text"  class="form-control input_user" placeholder="Ingrese usuario" name="txtUsuario" required/>
                <!--contraseña -->
                <label for="password">Contraseña</label>
                <input type="password"  class="form-control input_pass" placeholder="Ingrese contraseña" name="txtClave" required/><br>
                <!-- boton -->
                
                <input type="submit" class="btn btn-primary" value="Ingresar" name="btnEntrar"/>
                
        
        </div>  
            </form>
            <br/><br/><br/><br/>
            <hr/>
        </div>
    </body>
</html>
