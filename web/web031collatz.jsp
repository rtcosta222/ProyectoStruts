<%-- 
    Document   : web031collatz
    Created on : 09-feb-2021, 3:28:02
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
        <title>MVC Struts</title>
    </head>
    <body>
        <h1>Conjetura de Collatz</h1>
        <html:form action="/Action031Collatz">
            <label>Introduzca num para comprobar la conjetura:</label>
            <html:text property="numcollatz"/>
            <html:submit value="Generar tabla"/>
        </html:form>
    
        <logic:present name="collatzejecucion">
            <ul>
                <bean:write name="collatzejecucion" filter="false"/>
            </ul>
        </logic:present>
    </body>
</html>
