<%-- 
    Document   : newjsp
    Created on : 10-feb-2021, 1:19:03
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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <html:form action="/NewStrutsAction">
            <label>Introduzca nombre: </label>
            <html:text property="znombre"/>
            <html:submit value="Press"/>
        </html:form>
            
        <logic:present name="nombre">
            <bean:write name="nombre" filter="false"/>
        </logic:present>
    </body>
</html>
