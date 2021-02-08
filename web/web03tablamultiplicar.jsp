<%-- 
    Document   : web03tablamultiplicar
    Created on : 08-feb-2021, 20:33:23
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
        <title>Struts - Prácticas</title>
    </head>
    <body>
        <h1>Tabla de Multiplicar</h1>
        <html:form action="/Action03TablaMultiplicar">
            <label>Intro multiplicando: </label>
            <html:text property="respuesta"/>
            <html:submit value="Generar tabla"/>
        </html:form>
            
        <logic:present name="tablamulti">
            <table border="1">
                <tbody>
                    <tr><td>Multiplicar</td></tr>                        
                    <bean:write name="tablamulti" filter="false"/>
                </tbody>
            </table>
        </logic:present>
    </body>
</html>
