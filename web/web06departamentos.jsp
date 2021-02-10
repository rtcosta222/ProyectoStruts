<%-- 
    Document   : web06departamentos
    Created on : 09-feb-2021, 20:30:23
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
        <h1>Action Form Departamentos</h1>
        <html:form action="/Action06Departamentos">
            <html:submit value="Presione para ver tabla Dept"/>
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
