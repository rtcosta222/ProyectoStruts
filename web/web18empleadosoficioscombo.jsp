<%-- 
    Document   : web18empleadosoficioscombo
    Created on : 17-feb-2021, 18:05:03
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
        <h1>Empleados por oficio - combo</h1>
        <html:form action="/Action18EmpleadosOficioCombo">
            <label>Seleccione oficio:</label>
            <html:select property="oficio">
                <logic:iterate name="LISTAOFICIOS" id="oficio">
                    <html:option value="${oficio}">
                        <bean:write name="oficio"/>
                    </html:option>
                </logic:iterate>
            </html:select>
            <button type="submit">Ver empleados</button>
        </html:form>

        <hr/>  
        <%-- Solución con html como parámetro:
                <logic:present name="empsOficio">
                    <bean:write name="empsOficio" filter="false"/>
                </logic:present>  
        --%>
            <%-- Solución con objeto como parámetro:
        --%>
        <logic:present name="empsOficio">
            <table>
                <thead>
                    <tr><th>Apellido</th><th>Oficio</th><th>Salario</th><th></th></tr>
                </thead>
                <tbody>
                    <logic:iterate name="empsOficio" id="emp">
                        <tr>
                            <td><bean:write name="emp" property="apellido"/></td>
                            <td><bean:write name="emp" property="oficio"/></td>
                            <td><bean:write name="emp" property="salario"/></td>
                            <td><html:link action="/Action14DetallesEmpleado?idEmpIncrementar=${emp.idEmpleado}&oficioSeleccionado=${emp.oficio}">
                                    Cambiar salario
                                </html:link>
                            </td>
                            </tr>
                            <html:link action="/Action?empno=${emp.idEmpleado}&oficioseleccionado=${emp.oficio}">
	Pulsar
</html:link>
                    </logic:iterate>
                </tbody>
            </table>
        </logic:present>
    </body>
</html>
