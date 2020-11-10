<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cursos</title>
    </head>
    <body>
         <h1>Cursos</h1>
        <p><a href="inicio_2?action=add">Nuevo Registro</a></p>
             <table border="1">
            <tr>
                <th><b>Id_curso</b></th>
                <th><b>Descripcion</b></th>
                <th><b>Modificar</b></th>
                <th><b>Eliminar</b></th>
            </tr>
            <c:forEach var="item" items="${cursos}">
                <tr>
                    <td>${item.id_curso}</td>
                    <td textarea name="contenido" rows="4" cols="20">${item.descripcion}</td>      
                    <td><a href="inicio_2?action=edit&id_curso=${item.id_curso}">Modificar</a></td>
                    <td><a href="inicio_2?action=delete&id_curso=${item.id_curso}" onclick="return(confirm('Esta Seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
