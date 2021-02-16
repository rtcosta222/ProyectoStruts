                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                   <%-- 
    Document   : web13eliminardepartamento
    Created on : 12-feb-2021, 20:42:33
    Author     : lscar
    Supuesto   : Cuando entremos en la página, mostramos todos los departamentos
                 en una tabla. Tendremos un formulario con una caja de texto que 
                 nos pedirá el ID del departamento a eliminar. Cuando eliminemos, 
                 debemos volver a ver la tabla de departamentos con los cambios.
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
        <h1>Eliminar Departamento</h1>
        <html:form action="/Action13EliminarDepartamento">
            <label>Id Dept: </label>
            <html:text property="deptno"/>
            <button type="submit">Eliminar dept</button>
        </html:form>  
        <logic:present name="tabladepartamentos">
            <bean:write name="tabladepartamentos" filter="false"/>
        </logic:present>
    </body>
</html>
