<%-- 
    Document   : web081insertardepartamento
    Created on : 10-feb-2021, 18:24:54
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
        <h1>Insertar Dept (con ActionForm particular)</h1>
        <html:form action="/Action081InsertarDepartamento">
            <label>Introduzca DEPT_NO: </label>
            <html:text property="deptno"/>
                <span style="color:red"><html:errors property="numero"/></span>
            <label>Introduzca DNOMBRE: </label>
            <html:text property="dnombre"/>
                <span style="color:red"><html:errors property="nombre"/></span>
            <label>Introduzca LOC: </label>
            <html:text property="loc"/>
                <span style="color:red"><html:errors property="loc"/></span>
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
