<%-- 
    Document   : web09menudepartamentodinamico
    Created on : 12-feb-2021, 18:22:24
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
        <h1>Menú dinámico departamentos</h1>
        <logic:present name="OFICIOS">
            <ul>
                <logic:iterate name="OFICIOS" id="ofi">
                    <li>
                        <html:link action="/Action09EmpleadosDepartamento"
                                   paramId="oficio"
                                   paramName="ofi">
                            <bean:write name="ofi"/> 
                        </html:link>
                    </li>
                </logic:iterate>
            </ul>
        </logic:present>
       
        <ul>
            <li>
                <html:link action="/Action09DetallesDepartamento?iddepartamento=10">
                    CONTABILIDAD
                </html:link>
            </li>
        </ul>
    </body>
</html>
