<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="_top.jsp" %>
<style>
    #opciones li a{
        text-decoration: none;
        font-size: 14px;
    }
</style>
<ul id="opcion">
    <c:forEach var="opcion" items="${PermisosAsignados}">
        <li>
            <a href="${pageContext.servletContext.contextPath}${opcion.url}?op=${opcion.idmenu}"/>
        </li>
    </c:forEach>
</ul>
<%@include file="_down.jsp" %>