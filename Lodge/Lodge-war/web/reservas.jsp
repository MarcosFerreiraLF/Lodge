<%-- 
    Document   : reservas
    Created on : 05/12/2018, 02:54:21
    Author     : marco
Pagina destina listar reservas do logado
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reservas</title>
        <link rel="stylesheet" type="text/css" href="estilo2.css"/>
    </head>
    <body>
        <h1>Reservas do(a) ${cliente.nome}</h1>
    <c:choose>
        <c:when test="${empty lista_reservas}">
            <p>- N&atilde;o h&aacute; reservas registradas </p>
        </c:when>
        <c:otherwise>
            <table>
                <thead>
                    <tr>
                        <th>Estabelecimento </th>
                        <th>Quarto </th>
                        <th>Entrada </th>
                        <th>Saida </th>
                        <th>Diária </th>
                        <th> </th>
                    </tr>
                </thead>
                <tbody>

                <c:forEach var="reserva" items="${lista_reservas}">
                    <tr>
                        <td>${reserva.nomeHotel} </td>
                        <td>${reserva.numeroQuarto} </td>
                        <td>${reserva.dt_entrada} </td>
                        <td>${reserva.dt_saida} </td>
                        <td>${reserva.diaria} </td>

                        <td> <a href="${pageContext.request.contextPath}/cancelarReserva?id=<c:out value="${reserva.id}"/>">Cancelar reserva</a> </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </c:otherwise>
    </c:choose>
            
            <a href="${pageContext.request.contextPath}/inicio">Home</a>
</body>
</html>
