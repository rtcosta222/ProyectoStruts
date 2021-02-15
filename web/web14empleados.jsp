<%-- 
    Document   : web14empleados
    Created on : 15-feb-2021, 17:52:45
    Author     : lscar
    Práctica   : Arrancamos en web09menu.jsp
                    web14empleados
                    Dibujamos todos los apellidos de los empleados, con un enlace 
                    para mostrar Detalles
                    web14detallesempleado
                    Dibujamos los detalles del empleados seleccionado.
                    Podremos volver al listado de empleados con otro enlace.
                    
                    Version 2:  Llamamos al MISMO Action14DetallesEmpleado
                    Dibujamos un Action Link para Incrementar el salario.
                    Cada vez que pulsemos al Link subimos el salario en 1
                    y lo veremos. (Falta)
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Empleados por Apellido</title>
    </head>
    <body>
        <h1>Empleados por Apellido</h1>
        <!-- alldepts: viene de Action01MenuDeptDinamico -->
        <logic:present name="allemps">
            <ul>
                <!--  name: Nombre del parámetro buscado (request.setAttribute("name")
                            dentro del Action que nos trajo aqui).
                      id: Specifies a name that represents a single element on the 
                          iteratable object. Same as 
                                  for(Departamento departamento: alldepts) {}
                -->
                <logic:iterate name="allemps" id="empleado">
                    <li>
                        <!-- Llamando y pasando parámetros para una Action:
                                action: Que hacer cuando se pincha el link. 
                                paramId: Nombre del parámetro anyadido a la URL 
                                        (ej. fichero.jsp?paramId="x"). El valor ("x")
                                        deberá ser recuperado (request.getParameter())
                                        en la Action definida en "action".
                                paramName: Nombre del objeto de donde sacaremos los 
                                           datos. En este caso, ha sido definido 
                                           en el atributo "id" del <logicc:iterate>
                                           anterior.
                                paramProperty: Nombre del atributo del objeto 
                                        (como definido en el modelo) cuyo valor
                                        será enviado como parámetro (la "x" de
                                        arriba).
                        -->
                        <bean:write name="empleado" property="apellido"/> |
                        <html:link action="/Action14DetallesEmpleado"
                                   paramId="empno"
                                   paramName="empleado"
                                   paramProperty="idEmpleado">Detalles
                            <!--    name: Nombre del objeto a escribir (definido 
                                        en el <logicc:iterate> anterior.
                                    property: Nombre del atributo del objeto que será
                                    escrito.
                            -->
                        </html:link>
                    </li>
                </logic:iterate>
            </ul>
        </logic:present>        
    </body>
</html>
