<%-- 
    Document   : rweb08insertardepartamento
    Created on : 11-feb-2021, 2:14:48
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
        <h1>Insertar Hospital</h1>
        <html:form action="/Raction09InsertHospitales">
            <label>Hospital cod.: </label>
            <html:text property="hcod"/><br/>
                <span style="color:red"><html:errors property="numero"/></span>
            <label>Nombre: </label>
            <html:text property="hnom"/><br/>
                <span style="color:red"><html:errors property="nombre"/></span>
            <label>Dirección: </label>
            <html:text property="hdir"/><br/>
                <span style="color:red"><html:errors property="direccion"/></span>
            <label>Teléfono: </label>
            <html:text property="htel"/><br/>
                <span style="color:red"><html:errors property="telefono"/></span>
            <label>Núm. de camas: </label>
            <html:text property="hncamas"/><br/>
            <html:submit value="Insertar Hospital"/><br/>
        </html:form>
        
        <logic:present name="allhosps">
            <table border="1">
                <thead>
                    <tr><th>Hospital_cod</th><th>Nombre</th><th>Dirección</th><th>Telefono</th><th>Num. camas</th></tr>
                </thead>
                <tbody>
                    <bean:write name="allhosps" filter="false"/>            
                </tbody>
            </table>
        </logic:present>
    </body>
</html>
