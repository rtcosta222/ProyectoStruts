<%-- 
    Document   : web07buscardepartamentos
    Created on : 10-feb-2021, 16:40:48
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
        <h1>Buscar departamento</h1>
        <html:form action="/Action07BuscarDepartamentos">
            <label>Introduzca DEPT_NO: </label>
            <html:text property="deptno"/>
            <html:submit value="Presione para ver Dept"/>
        </html:form>
            
        <logic:present name="dept">
            <bean:write name="dept" filter="false"/>
        </logic:present>
            
        <logic:present name="mensaje">
            <bean:write name="mensaje" filter="false"/>
        </logic:present>
    </body>
</html>
