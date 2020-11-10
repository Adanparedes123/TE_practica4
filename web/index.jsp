<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica 4</title>
    </head>
    <body>
          <h1>Estudiantes</h1>
        <p><a href="inicio?action=add">Nuevo Registro</a></p>

        <table border="1">
            <tr>
                <th><b>Id_estudiante</b></th>
                <th><b>Nombres</b></th>
                <th><b>Apellidos</b></th>
                <th><b>Correo</b></th>
                <th><b>Modificar</b></th>
                <th><b>Eliminar</b></th>
            </tr>
            <c:forEach var="item" items="${estudiantes}">
                <tr>
                    <td>${item.id_estudiante}</td>
                    <td>${item.nombre}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.correo}</td>       
                    <td><a href="inicio?action=edit&id_estudiante=${item.id_estudiante}">Modificar</a></td>
                    <td><a href="inicio?action=delete&id_estudiante=${item.id_estudiante}" onclick="return(confirm('Esta Seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>
