<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../_top.jsp"%>

<link href="../css/main.css" rel="stylesheet" type="text/css"/>
<link href="../css/reset.css" rel="stylesheet" type="text/css"/>
<link href="../css/style.css" rel="stylesheet" type="text/css"/>
<link href="../css/tabla.css" rel="stylesheet" type="text/css"/>

<div class="contenedor">
    <div class="col-6 col-t-12">
        <h1>Clientes</h1>
        <br/>
        <form name="form_factura" onsubmit="return validar();" action="${pageContext.servletContext.contextPath}/factura?accion=insertar_modificar" method="POST">

            <tr><th colspan="">Complete la información<br><br></th>
            <div class="form-group">
                <label for="formGroupExampleInput">ID Cliente :</label>
                <input type="text" class="form-control" id="formGroupExampleInput" name="txtcliente" value="${factura.getIdCliente()}" readonly="readonly" />
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput">Nombres :</label>
                <input type="text" class="form-control" id="formGroupExampleInput" name="txtnombre" id="txtnombre" value="${factura.getNombre()}" />
            </div>
            <div class="form-group">
                <label for="formGroupExampleInput">Apellidos :</label>
                <input type="text" class="form-control" id="formGroupExampleInput" name="txtapellido" id="txtapellido" value="${factura.getApellido()}"/>
            </div>
            <br/>
            <div class="buttons"><ul><input type="submit"   class="btn btn-primary" value="Guardar" name="guardar"/><li><a href="#" onclick="javascript: return window.history.back()">Regresar</a></li></ul></div>
        </form>
    </div> 
</div>
<script>
    function validar() {
        var factura = document.getElementById('txtnombre');
        if (factura.value.length == 0) {
            factura.focus();
            alert("Digite numero de factura");
            return false;
        }
        return true;
    }

</script>