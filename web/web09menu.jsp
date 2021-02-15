<%-- 
    Document   : webmenu
    Created on : 11-feb-2021, 17:29:46
    Author     : lscar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC con Struts</title>
    </head>
    <body>
        <h1>Menu de Struts</h1>
        <ul>
            <li><html:link href="web02sumarnumeros.jsp">Sumar números</html:link></li>
                <!--Cómo se entera el sistema de la parte de la tabla que está
                    en web06departamentos.jsp? -->
            <li><html:link action="/Action06Departamentos">Departamentos</html:link></li>
            <li><html:link href="web09menudepartamentosestatico.jsp">Menú departamentos estático</html:link></li>
            <li><html:link action="/Action09MenuDepartamentosDinamico">Menú departamentos dinámico</html:link></li>
            <li><html:link action="/Action13TablaDepartamentos">Menú Eliminar Departamento</html:link></li>
            <li><html:link action="/Action14ApellidoEmpleados">Menú Detalles Empleado Dinámico</html:link></li>
        </ul>
    </body>
</html>
