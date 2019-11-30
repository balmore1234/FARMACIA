<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../_top.jsp"%>

<link href="../css/main.css" rel="stylesheet" type="text/css"/>
<link href="../css/reset.css" rel="stylesheet" type="text/css"/>
<link href="../css/style.css" rel="stylesheet" type="text/css"/>
<link href="../css/tabla.css" rel="stylesheet" type="text/css"/>
<div class="contenedor">
    <div class="col-6 col-t-12">
        <h1>Presentaciones</h1>
        <br/>
        <form name="form_presentacion" onsubmit="return validar();" action="${pageContext.servletContext.contextPath}/Presentaciones?accion=insertar_modificar" method="POST">
           
            <h2>Complete la informacion</h2><br/><br/>
            <div class="form-group">
                <label>Id Presentación :</label>
                <input type="text" class="form-control"  name="txtpresentacion" value="${Presentaciones.getIdPresentacion()}" readonly="readonly">
            </div>
            <div class="form-group">
                <label>Nombre Presentción:</label>
                <input type="text" class="form-control" name="txtnombre" id="txtnombre" value="${Presentaciones.getNombre()}">
            </div>
            <br/>
            <div class="buttons">
                <ul><input type="submit"   class="btn btn-primary" value="Guardar" name="guardar"/>
                    <li><a href="#" class="btn" onclick="javascript: return window.history.back()">Regresar</a></li>
                </ul>
            </div>
        </form>
    </div> 
</div>
<script>
    function validar() {
        var Presentaciones = document.getElementById('txtnombre');
        if (Presentaciones.value.length == 0) {
            Presentaciones.focus();
            alert("Digite nombre de la Presentacion");
            return false;
        }
        return true;
    }
</script>
