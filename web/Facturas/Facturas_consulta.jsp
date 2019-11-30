<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../_top.jsp"%>

<div class="contenedor">
    <br/><br/><br/>
    <center>
        <c:if test="${resultado!=null}">
            <c:if test="${resultado==1}">
                <p style="color:darkgreen"><strong class="alert alert-success alert-dismissible">Operación realizada correctamente.</strong></p>
            </c:if>
            <c:if test="${resultado==0}">
                <p style="color:darkred"><strong class="alert alert-danger alert-dismissible fade show">La operación no se realizó.</strong></p>
            </c:if>

        </c:if>
    </center>
    <div class="col-6 col-t-12">
        <h1>Listado de Facturas</h1>
        <br> 
        <form class="form-inline" action="${pageContext.servletContext.contextPath}/factura" method="get">

            <div class="form-group mx-sm-6 mb-2">
                <h5>Ingrese informacion  :</h5>
                <input  class="form-control"  name="txtBusqueda" id="txtBusqueda" value="${valor}">
            </div>
            <div class="form-group mx-sm-2 mb-2">
                <button type="submit" class="btn btn-primary mb-2"  value="Buscar">Buscar</button>
            </div>
            <div class="form-group mx-sm-2 mb-2">
                <ul>        
                    <a class="btn btn-warning" href="${pageContext.servletContext.contextPath}/Factura?accion=insertar">Nuevo</a></ul>
            </div>
        </form>
    </div>


    <br/>${tabla}
</div>
<script>
    window.onload = function () {
        document.getElementById("txtBusqueda").focus();
    };</script> 
    <%@include file="../_down.jsp"%>
