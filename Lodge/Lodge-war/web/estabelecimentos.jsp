<%-- 
    Document   : resultado
    Created on : 01/12/2018, 19:36:07
    Author     : mathe

    PAGINA PARA LISTAR ESTABELECIMENTOS
--%>


<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Estabelecimentos</title>
        <link rel="stylesheet" type="text/css" href="estilo2.css"/>
    </head>
    <body>
       <h1>Lista de Estabelecimentos</h1>

        <c:choose>
            <c:when test="${empty lista}">
                <p>- N&atilde;o h&aacute; estabelecimentos registrados </p>
            </c:when>
            <c:otherwise>

                <table>
                    <thead>
                        <tr>
                            <th>Nome </th>
                            <th>Endereço </th>
                            <th> </th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="estabelecimento" items="${lista}">
                            <tr>
                                <td>${estabelecimento.descricao} </td>
                                <td>${estabelecimento.endereco} </td>
                                <td> <a href="${pageContext.request.contextPath}/listarQuartos?id=<c:out value="${estabelecimento.id}"/>">Ver hotel</a> </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:otherwise>
        </c:choose>

        <p>
           
            <a href="${pageContext.request.contextPath}/inicio">Home</a>
        </p>
    </body>
</html>
