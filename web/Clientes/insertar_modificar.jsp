<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../_top.jsp"%>

<link href="../css/main.css" rel="stylesheet" type="text/css"/>
<link href="../css/reset.css" rel="stylesheet" type="text/css"/>
<link href="../css/style.css" rel="stylesheet" type="text/css"/>
<link href="../css/tabla.css" rel="stylesheet" type="text/css"/>

<div class="contenedor">
    <h1>Clientes</h1>
    <div class="col-6 col-t-12">
        
        <br/>
        <form name="form_cliente" onsubmit="return validar();" action="${pageContext.servletContext.contextPath}/Clientes?accion=insertar_modificar" method="POST">
              <h6><label for="formGroupExampleInput">Complete la información</label></h6><br><br>
           
            <div class="form-group">
                <h6><label for="formGroupExampleInput">ID Cliente :</label></h6>
                <input type="text" class="form-control" id="formGroupExampleInput" name="txtcliente" value="${Clientes.getIdCliente()}" readonly="readonly" />
            </div>
            <div class="form-group">
                <h6><label for="formGroupExampleInput">Nombres :</label></h6>
                <input type="text" class="form-control" onkeypress="return soloLetras(event)" name="txtnombre" id="txtnombre" value="${Clientes.getNombre()}" required autofocus />
            </div>
            <div class="form-group">
                <h6><label>Apellidos :</label></h6>
                <input type="text" class="form-control" onkeypress="return soloLetras(event)" name="txtapellido" id="txtapellido" value="${Clientes.getApellido()}" required autofocus/>
            </div>
            <br/>
            <div class="buttons"><ul><input type="submit"   class="btn btn-primary" value="Guardar" name="guardar"/><li><a href="#" class="btn" onclick="javascript: return window.history.back()">Regresar</a></li></ul></div>
        </form>
    </div> 
</div>
<script>
    function validar() {
        var Clientes = document.getElementById('txtnombre');
        if (Clientes.value.length == 0) {
            Clientes.focus();
            alert("Digite nombre de la Cliente");
            return false;
        }
        return true;
    }
function soloLetras(e){
       key = e.keyCode || e.which;
       tecla = String.fromCharCode(key).toLowerCase();
       letras = " áéíóúabcdefghijklmnñopqrstuvwxyz";
       especiales = "8-37-39-46";

       tecla_especial = false
       for(var i in especiales){
            if(key == especiales[i]){
                tecla_especial = true;
                break;
            }
        }

        if(letras.indexOf(tecla)==-1 && !tecla_especial){
            return false;
        }
    }
</script>