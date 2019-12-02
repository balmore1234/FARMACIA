<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/reset.css" />
        <link rel="stylesheet" type="text/css" href="css/main.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="css/tabla.css" media="screen" />
        <style>
            #table01 td{ padding-top: 8px; cursor: pointer}
        </style>
        <title>Roles</title>
    </head>
    <body>
        <div id="contenido" style="padding: 10px">
            <h1>Listado de Roles</h1>
            ${tabla}
            <script>
            //funcion javascript que se ejecuta al hacer click en una fila
            //recibe un elemento de tipo fila como parametro: row
                function _Seleccionar_(row) {
            //recupera el idavion de la fila, en la celda 0
                    var idrol = row.cells[0].innerHTML;
            //recupera descripcion del avion de la fila, en la celda 1
                    var rol = row.cells[1].childNodes[0].innerHTML;
            //asigna a las cajas de texto de la ventana padre los valores
            //obtenidos
                    window.opener.setDataRol(idrol, rol);
            //cierra la ventana
                    window.close();
                }
            </script>
        </div>
    </body>
</html>