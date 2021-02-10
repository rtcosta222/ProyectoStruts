<%-- 
    Document   : web05persona
    Created on : 09-feb-2021, 19:18:15
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
        <h1>Action Form Persona</h1>
        <html:form action="/Action05Persona">
            <label>Nombre: </label>
            <html:text property="nombre"/>
                <span style="color:red"><html:errors property="nombre"/></span>
            <label>Email: </label>
            <html:text property="email"/>
                <span style="color:red"><html:errors property="email"/></span>
            <label>Edad </label>
            <html:text property="edad"/>
                <span style="color:red"><html:errors property="edad"/></span>
            <html:submit value="Enviar datos"/>
        </html:form>
        
        <logic:present name="datospersona">
            <bean:write name="datospersona" filter="false"/>
        </logic:present>
    </body>
</html>
