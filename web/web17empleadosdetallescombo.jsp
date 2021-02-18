<%-- 
    Document   : web17empleadosdetallescombo
    Created on : 17-feb-2021, 16:30:03
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
        <h1>Empleados Detalles Select</h1>
        <html:form action="/Action17EmpleadosDetallesCombo">
            <label>Seleccione empleado:</label>
            <html:select property="idempleado">
                <logic:iterate name="LISTEMPLEADOS" id="emp">
                    <html:option value="${emp.idEmpleado}">
                        <bean:write name="emp" property="apellido"/>
                    </html:option>
                </logic:iterate>
            </html:select>
            <button type="submit">Detalles empleado</button>
        </html:form>
            
        <hr/>
        <logic:present name="EMPLEADO">
            <bean:write name="EMPLEADO" property="apellido"/>, Oficio:
            <bean:write name="EMPLEADO" property="oficio"/>, Salario:
            <bean:write name="EMPLEADO" property="salario"/>
        </logic:present>
    </body>
</html>
