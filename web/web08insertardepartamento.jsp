<%-- 
    Document   : web08insertardepartamento
    Created on : 10-feb-2021, 17:41:55
    Author     : lscar
    Supuesto   : web08insertardepartamento
                 Versión 1: Las cajas para insertar un departamento.
                    Si insertamos, vamos a la página de los departamentos. 
                    (La del botón 06)
                 Versión 2: Un ActionForm que controle que nombre y localidad 
                 son obligatorios.
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
        <h1>Insertar Dept</h1>
        <html:form action="/Action08InsertarDepartamento">
            <label>Introduzca DEPT_NO: </label>
            <html:text property="deptno"/>
            <label>Introduzca DNOMBRE: </label>
            <html:text property="dnombre"/>
            <label>Introduzca LOC: </label>
            <html:text property="loc"/>
            <html:submit value="Presione para insertar Dept"/>
        </html:form>
            
        <logic:present name="datosdept">
            <table border="1">
                <thead>
                    <tr><th>DEPT_NO</th><th>DEPT_NOM</th><th>LOCALIDAD</th></tr>
                </thead>
                <tbody>
                    <bean:write name="datosdept" filter="false"/>
                </tbody>
            </table>
        </logic:present>
    </body>
</html>
