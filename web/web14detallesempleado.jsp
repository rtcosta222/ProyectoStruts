<%-- 
    Document   : web14detallesempleado
    Created on : 15-feb-2021, 17:09:36
    Author     : lscar
    Práctica   : Arrancamos en web09menu.jsp
                    web14empleados
                    Dibujamos todos los apellidos de los empleados, con un enlace 
                    para mostrar Detalles
                    web14detallesempleado
                    Dibujamos los detalles del empleados seleccionado.
                    Podremos volver al listado de empleados con otro enlace.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>MVC con Struts - Empleados</title>
    </head>
    <body>
        <h1>Detalles de Empleado</h1>
        <html:link action="/Action14ApellidoEmpleados">Volver al menú Apellidos Empleado</html:link>
        <logic:present name="detallesEmp">
            <bean:write name="detallesEmp" filter="false"/>
        </logic:present>
    </body>
</html>
