<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../_top.jsp"%>

<div class="contenedor">
    <div class="col-6 col-t-12">
        <form name="form_categoria" onsubmit="return validar();" action="${pageContext.servletContext.contextPath}/Documentos?accion=insertar_modificar" method="POST">
            <h1>Tipos de Documentos</h1>
            <h2>Complete la informacion</h2><br/><br/>
            <div class="form-group">
                <label for="formGroupExampleInput">Id tipo de documento :</label>
                <input type="text" class="form-control" id="formGroupExampleInput" name="txtdocumento" value="${Tipo_Documentos.getIdTipo_Documento()}" readonly="readonly">
            </div>
            <div class="form-group">
                <h6><label>Nombre tipo de documento :</label></h6>
                <input type="text" class="form-control" onkeypress="return soloLetras(event)" name="txtnombre" id="txtnombre" value="${Tipo_Documentos.getNombre()}" required autofocus/>
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
        var documentos = document.getElementById('txtnombre');
        if (documentos.value.length == 0) {
            documentos.focus();
            alert("Digite nombre de tipo de documento");
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
 <%@include file="../_down.jsp"%>