<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../_top.jsp"%>
<script>
    function abrirVentana(URL) {
//funcion javascript para abrir un subventana para realizar
//busquedas, se le pasa la pagina a mostrar como parametro
        window.open(URL, "ventana1", "width=700,height=400,scrollbars=YES,statusbar=YES,top=150,left=300")
    }

    function test() {
        var p = document.getElementById("txtClave");
        var c = document.getElementById("chec");
        p.type = (c.checked) ? "text" : "password";
    }


    function soloNumeros(e) {
        var key = window.Event ? e.which : e.keyCode
        return (key >= 48 && key <= 57)
    }

</script>

<br/>
<div class="contenedor">
    <div class="col-6 col-t-12">
        <form name="form_usuarios" onsubmit="return validar();" action="${pageContext.servletContext.contextPath}/Usuarios?accion=insertar_modificar" method="POST">

            <h1>Usuarios</h1>
            <h2>Complete la informacion</h2><br/><br/>
            <div class="form-group">
                <label>Nombre de  Usuario :</label>
                <input type="text" class="form-control"  name="txtIdusu" value="${usuario.getIdusuario()}" minlength="5" maxlength="40"  placeholder="Escribe tu nombre de usuario" required autofocus>
            </div>
            <div class="form-group">
                <label>Nombres :</label>
                <input type="text" class="form-control"  name="txtNombre" id="txtNombre" value="${usuario.getNombres()}" minlength="5" maxlength="40"  placeholder="Escribe tu nombre completo" required autofocus>
            </div>
            <div class="form-group">
                <label>Apellidos :</label>
                <input type="text" class="form-control" minlength="5" maxlength="40" size="30" placeholder="Escribe tu apellido" required autofocus name="txtApellido" id="txtApellido" value="${usuario.apellidos}" >
            </div>
            <div class="form-group">
                <label>DUI :</label>
                <input type="text" class="form-control"   maxlength="40" size="30" placeholder="Escriba su DUI" required name="txtDUI" id="txtDUI" value="${usuario.DUI}" title="Ingrese # de DUI " />
            </div>
            <div class="form-group">
                <label>Telefono :</label>
                <input type="text" class="form-control" maxlength="9" size="30" placeholder="Ej: 77774444" required name="txtTelefono" id="txtTelefono" value="${usuario.telefono}"/>
            </div>
            <div class="form-group">
                <label>Clave :</label>
                <input type="text" class="form-control" minlength="5" maxlength="20" size="30" placeholder="Escribe tu clave" required title="Tamaño mínimo: 5. Tamaño máximo: 20" name="txtClave" id="txtClave" value="${usuario.clave}">
                <label>
                    <input type="checkbox" id="chec" name="chec" onclick="test()">Mostrar Contraseña</label>
            </div>
            <div class="col-xs-12 col-md-9">
                <div class="form-group">
                    <label for="">Rol :</label>
                    <div class="input-group">
                        <input type="text"  name="txtIdrol" class="form-control" class="form-control"id="txtIdrol" value="${usuario.getIdrol()}"  readonly="readonly">
                        <input type="text" class="form-control" name="txtRol" id="txtRol" readonly="readonly" value="${rol.getRol()}" placeholder="Elija un Rol" required>
                        <input type="button" value="..." class="btn btn-success" onclick="abrirVentana('${pageContext.servletContext.contextPath}/Usuarios?accion=listado_roles');">


                    </div>
                </div>
            </div>

            <br/><br/><br/><br/>
            <div class="buttons">
                <ul><input type="submit"   class="btn btn-primary" value="Guardar" name="guardar"/>
                    <li><a href="#" class="btn" onclick="javascript: return window.history.back()">Regresar</a></li>
                </ul>
            </div>

        </form>
    </div> 
</div>
<script>

//funcion que se llamará al seleccionar el origen desde la ventana
    function setDataRol(idrol, rol) {
        document.getElementById("txtIdrol").value = idrol;
        document.getElementById("txtRol").value = rol;
    }
</script>
<%@include file="../_down.jsp"%>


