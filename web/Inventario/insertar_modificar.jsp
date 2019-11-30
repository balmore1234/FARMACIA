<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../_top.jsp"%>
<script>
    function abrirVentana(URL) {
//funcion javascript para abrir un subventana para realizar
//busquedas, se le pasa la pagina a mostrar como parametro
        window.open(URL, "ventana1", "width=700,height=400,scrollbars=YES,statusbar=YES,top=150,left=300")
    }

</script>

<br/>
<div class="contenedor">
    <div class="col-6 col-t-12">
        <form name="form_inventarios" onsubmit="return validar();" action="${pageContext.servletContext.contextPath}/Inventarios?accion=insertar_modificar" method="POST">

            <h1>Productos</h1>
            <h2>Complete la informacion</h2><br/><br/>
            <div class="form-group">
                <label>Id Producto :</label>
                <input type="text" class="form-control" readonly="readonly" name="txtidproducto" value="${Inventario.getIdProducto()}"/>
            </div>

            <div class="form-group">
                <label>Nombre :</label>
                <input type="text" class="form-control"    name="txtnombre" id="txtnombre" required value="${Inventario.getNombre()}" minlength="5" maxlength="40" size="30" placeholder="Escribe nombre del producto" required autofocus/>
            </div>
            <div class="form-group">
                <label>Precio :</label>
                <input type="text" class="form-control"  placeholder="Ingrese el precio" required autofocus name="txtprecio" id="txtprecio" value="${Inventario.getPrecio()}"/>
            </div>
            <div class="form-group">
                <label>Fecha de vencimiento :</label>
                <input class="form-control" type="Date"   name="txtfecha" id="txtfecha" value="${Inventario.getFecha_Vencimiento()}"  required />

            </div>
            <div class="col-xs-12 col-md-9">
                <div class="form-group">
                    <label for="">Categoria :</label>
                    <div class="input-group">
                        <input type="text"    class="form-control" name="txtidcategoria" id="txtidcategoria" value="${Inventario.getIdCategoria()}"  readonly="readonly">
                        <input type="text" class="form-control" name="txtcategoria" id="txtcategoria" readonly="readonly" value="${Categoria.getNombre()}" placeholder="Elija una categoria" required>
                        <input type="button" value="..." class="btn btn-success" onclick="abrirVentana('${pageContext.servletContext.contextPath}/Inventarios?accion=listado_categorias');">


                    </div>
                </div>
                <div class="form-group">
                    <label for="">Presentación :</label>
                    <div class="input-group">
                        <input type="text"   class="form-control" name="txtidpresentacion" id="txtidpresentacion" value="${Inventario.getIdPresentacion()}" readonly="readonly">
                        <input type="text" class="form-control" name="txtpresentacion" id="txtpresentacion" readonly="readonly" value="${Presentaciones.getNombre()}" placeholder="Elija una presentacion" required>
                        <input type="button" value="..." class="btn btn-success" onclick="abrirVentana('${pageContext.servletContext.contextPath}/Inventarios?accion=listado_presentacion');">


                    </div>
                </div>
            </div>

            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            <div class="buttons">
                <ul><input type="submit"   class="btn btn-primary" value="Guardar" name="guardar"/>
                    <li><a href="#" class="btn" onclick="javascript: return window.history.back()">Regresar</a></li>
                </ul>
            </div>


        </form>
    </div> 
</div>
<script>

 window.onload = function () {
//inicializamos el control de fecha
 var dtp = new DateTimePicker('.datepicker', {
 timePicker: true, // activamos la selección de hora
 format: 'd/m/Y H:i' //formato de fecha y hora
 });
 };

//funcion que se llamará al seleccionar el origen desde la ventana
    function setDataCategoria(idcategoria, categoria) {
        document.getElementById("txtidcategoria").value = idcategoria;
        document.getElementById("txtcategoria").value = categoria;
    }
    function setDataPresentacion(idpresentacion, presentacion) {
        document.getElementById("txtidpresentacion").value = idpresentacion;
        document.getElementById("txtpresentacion").value = presentacion;
    }
</script>
<%@include file="../_down.jsp"%>


