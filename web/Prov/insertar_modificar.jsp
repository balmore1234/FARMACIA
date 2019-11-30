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
                <input type="text" class="form-control"  name="txtnombre" id="txtnombre" value="${Proveedor.getNombre()}"/>
            </div>
            <div class="form-group">
                <label>Dirección :</label>
                <input type="text" class="form-control"  name="txtdireccion" id="txtdireccion" value="${Proveedor.getDireccion()}"/>
            </div>
            <div class="form-group">
                <label>Telefono :</label>
                <input type="text" class="form-control"  name="txttelefono" id="txttelefono" value="${Proveedor.getTelefono()}"/>
            </div>
            <div class="form-group">
                <label>Correo :</label>
                <input type="text" class="form-control"  name="txtcorreo" id="txtcorreo" value="${Proveedor.getCorreo()}"/>
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
</script>
<%@include file="../_down.jsp"%>
