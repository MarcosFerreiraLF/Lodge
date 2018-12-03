<%-- 
    Document   : resultado
    Created on : 01/12/2018, 19:36:07
    Author     : mathe
--%>


<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="estilo2.css"/>
    </head>
    <body>
       <h1>Lista de Hoteis</h1>

        <c:choose>
            <c:when test="${empty lista}">
                <p>- N&atilde;o h&aacute; usuários registrados </p>
            </c:when>
            <c:otherwise>

                <table>
                    <caption>Tabela de Hoteis</caption>
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Endereço</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="user" items="${lista}">
                            <tr>
                                <td>${user.descricao} </td>
                                <td>${user.endereco} </td>
                                <td> <a href="${pageContext.request.contextPath}/buscarquartos?id=<c:out value="${user.id}"/>">Ver Quartos</a> </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="2">Total de contatos: ${fn:length(lista)}</td>
                        </tr>
                    </tfoot>
                </table>

            </c:otherwise>
        </c:choose>

        <p>
           
            <a href="${pageContext.request.contextPath}/inicio">Voltar à página inicial</a>
        </p>
    </body>
</html>
