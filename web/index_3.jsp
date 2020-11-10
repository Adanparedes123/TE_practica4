<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inscripciones</title>
    </head>
    <body>
         <h1>Inscripciones</h1>
        <p><a href="inicio_3?action=add">Nuevo Registro</a></p>

        <table border="1">
            
            <tr>
                <th><b>Id_ins</b></th>
                <th><b>Id_curso</b></th>
                <th><b>Id_estudiante</b></th>
                <th><b>Nota_final</b></th>
                <th><b>Modificar</b></th>
                <th><b>Eliminar</b></th>
            </tr>
            <c:forEach var="item" items="${inscripciones}">
                <tr>
                    <td>${item.id_ins}</td>
                    <td>${item.id_curso}</td>
                    <td>${item.id_estudiante}</td>
                    <td>${item.nota_final}</td>       
                    <td><a href="inicio_3?action=edit&id_ins=${item.id_ins}">Modificar</a></td>
                    <td><a href="inicio_3?action=delete&id_ins=${item.id_ins}" onclick="return(confirm('Esta Seguro'))">Eliminar</a></td>
                </tr>
            </c:forEach> 
        </table>

    </body>
</html>
