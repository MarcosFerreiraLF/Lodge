<%-- 
    Document   : estabelecimento
    Created on : 03/12/2018, 15:18:29
    Author     : marco

Pagina de listagem de quartos
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estabelecimento</title>
        <link rel="stylesheet" type="text/css" href="estilo2.css"/>
    </head>
    <body>
        <h1>${estabelecimento.descricao}</h1>
        <c:choose>
            <c:when test="${empty lista_quartos}">
                <p>- N&atilde;o h&aacute; quartos registrados </p>
            </c:when>
            <c:otherwise>

                <table>
                    <thead>
                        <tr>
                            <th>Número </th>
                            <th>Descrição </th>
                            <th>Preço </th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="quarto" items="${lista_quartos}">
                            <tr>
                                <td>${quarto.numero} </td>
                                <td>${quarto.descricao} </td>
                                <td>R$ ${quarto.preco} </td>

                                <td> <a href="${pageContext.request.contextPath}/reserva?id=<c:out value="${quarto.id}"/>">Reservar</a> </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:otherwise>
        </c:choose>


        <ul class="slides-list" >
            <li class="slide" >
                <img src="imagens/quarto.jpg" />
            </li>
            <li class="slide" >
                <img src="imagens/quarto2.jpg" />
            </li>
            <li class="slide" >
                <img src="imagens/quarto4.jpg" />
            </li>
           
        </ul>
         <a href="${pageContext.request.contextPath}/inicio">Home</a>       
    </body>
</html>
