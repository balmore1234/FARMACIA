<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@include file="../_top.jsp"%>

<<div class="contenedor">
    <div class="col-6 col-t-12">
        <form name="form_categorias" onsubmit="return validar();" action="${pageContext.servletContext.contextPath}/Categorias?accion=insertar_modificar" method="POST">

            <h1>Categorias</h1>
            <h2>Complete la informacion</h2><br/><br/>
            <div class="form-group">
                <label>Id Categoria :</label>
                <input type="text" class="form-control"  name="txtcategoria" value="${Categoria.getIdCategoria()}" readonly="readonly">
            </div>
            <div class="form-group">
                <label>Nombres :</label>
                <input type="text" class="form-control" onkeypress="return soloLetras(event)" name="txtnombre" id="txtNombre" value="${Categoria.getNombre()}" minlength="5" maxlength="40"  placeholder="Ingrese nombre de la Categoria" required autofocus>
            </div>                     

</div>
          
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
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
        var Categorias = document.getElementById('txtnombre');
        if (Categorias.value.length == 0) {
            Categorias.focus();
            alert("Digite nombre de la Categoria");
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