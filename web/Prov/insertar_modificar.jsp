<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../_top.jsp"%>

<br/>
<div class="contenedor">
    <div class="col-6 col-t-12">
        <form name="form_proveedores" onsubmit="return validar();" action="${pageContext.servletContext.contextPath}/Proveedores?accion=insertar_modificar" method="POST">

            <h1>Categorias</h1>
            <h2>Complete la informacion</h2><br/><br/>
            <div class="form-group">
                <label>Id Proveedor :</label>
                <input type="text" class="form-control"  name="txtproveedor" value="${Proveedor.getIdProveedor()}" readonly="readonly">
            </div>
            <div class="form-group">
                <label>Nombre Proveedor :</label>
                <input type="text" class="form-control" onkeypress="return soloLetras(event)" name="txtnombre" id="txtnombre" value="${Proveedor.getNombre()}" required autofocus/>
            </div>
            <div class="form-group">
                <label>Dirección :</label>
                <input type="text" class="form-control"  name="txtdireccion" id="txtdireccion" value="${Proveedor.getDireccion()}" required autofocus/>
            </div>
            <div class="form-group">
                <label>Telefono :</label>
                <input type="text" class="form-control"  onKeyPress="return soloNumeros(event)" name="txttelefono" maxlength="8" id="txttelefono" value="${Proveedor.getTelefono()}" required autofocus/>
            </div>
            <div class="form-group">
                <label>Correo :</label>
                <input type="text" class="form-control"  name="txtcorreo"  onKeyUp="javascript:validateMail('txtcorreo')" id="txtcorreo" value="${Proveedor.getCorreo()}" required autofocus/>
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
        var Proveedores = document.getElementById('txtnombre');
        if (Proveedores.value.length == 0) {
            Proveedores.focus();
            alert("Digite nombre de un proveedor");
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
       function validateMail(idMail){
	//Creamos un objeto 
	object=document.getElementById(idMail);
	valueForm=object.value;
	// Patron para el correo
	var patron=/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,4})+$/;
	if(valueForm.search(patron)==0)	{
		//Mail correcto
		object.style.color="#000";
		return;
	}
	//Mail incorrecto
	object.style.color="#f00";
}
function soloNumeros(e){
	var key = window.Event ? e.which : e.keyCode
	return (key >= 48 && key <= 57)
}
</script>
<%@include file="../_down.jsp"%>
