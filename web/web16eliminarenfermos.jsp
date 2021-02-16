<%-- 
    Document   : web16eliminarenfermos
    Created on : 16-feb-2021, 17:33:46
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
        <h1>Uso de PlugIns: Eliminar Enfermos</h1>
        <html:form action="/Action15EliminarEnfermo">
            <label>Inscr.: </label>
            <html:text property="inscripcion"/>
            <button type="submit">Eliminar enfermo</button>
        </html:form>  
        
        <table border="1">
            <thead>
                <tr>
                    <th>Inscripción</th>
                    <th>Apellido</th>
                    <th>Dirección</th>
                    <th>Fecha_Nac</th>
                    <th>Sexo</th>
                    <th>NSS</th>
                </tr>
            </thead>
            <tbody>
                <logic:iterate name="LISTAENFERMOS" id="enfermo">
                    <tr>
                        <td><bean:write name="enfermo" property="inscripcion"/></td>
                        <td><bean:write name="enfermo" property="apellido"/></td>
                        <td><bean:write name="enfermo" property="direccion"/></td>
                        <td><bean:write name="enfermo" property="fecha_nac"/></td>
                        <td><bean:write name="enfermo" property="sexo"/></td>
                        <td><bean:write name="enfermo" property="nss"/></td>
                    </tr>
                </logic:iterate>
            </tbody>
        </table>
    </body>
</html>
