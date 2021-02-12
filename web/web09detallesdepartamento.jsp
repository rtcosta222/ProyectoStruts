<%-- 
    Document   : web09detallesdepartamento
    Created on : 12-feb-2021, 5:34:01
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
        <title>Detalles de Departamento</title>
    </head>
    <body>
        <h1>Detalles departamento</h1>
        <logic:present name="detallesdepartamento">
            <bean:write name="detallesdepartamento" filter="false"/>
        </logic:present>
    </body>
</html>
