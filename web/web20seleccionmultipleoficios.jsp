<%-- 
    Document   : web20seleccionmultipleoficios
    Created on : 18-feb-2021, 17:52:54
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
        <h1>Seleccion múltiple de Oficios</h1>
        <html:form action="/Action20SeleccionMultipleOficios">
            <ul>
                <logic:iterate name="LISTOFICIOS" id="oficio">
                    <li>
                        <html:multibox property="oficios">
                            <bean:write name="oficio"/>
                        </html:multibox>
                        <bean:write name="oficio"/>
                    </li>
                </logic:iterate>
            </ul>
            <button type="submit">Mostrar empleados</button>
        </html:form>
        <hr/>

        <logic:present name="LISTEMPLEADOS">
        <table border="1">
            <thead>
                <tr>
                    <th>Apellido</th>
                    <th>Oficio</th>
                    <th>Salario</th>
                    <th>Departamento</th>
                </tr>
            </thead>
            <tbody>
                <logic:iterate name="LISTEMPLEADOS" id="emp">
                    <tr>
                        <td><bean:write name="emp" property="apellido"/></td>
                        <td><bean:write name="emp" property="oficio"/></td>
                        <td><bean:write name="emp" property="salario"/></td>
                        <td><bean:write name="emp" property="deptno"/></td>
                    </tr>
                </logic:iterate>
            </tbody>
        </table>
    </logic:present>
    </body>
</html>
