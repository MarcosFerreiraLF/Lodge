<!--
    Material utilizado para as aulas pr�ticas das disciplinas da Faculdade de
Computa��o da Universidade Federal de Mato Grosso do Sul (FACOM / UFMS).
Seu uso � permitido para fins apenas acad�micos, todavia mantendo a
refer�ncia de autoria.
    Created on : 25/10/2010
    Author     : Prof� Jane Eleut�rio
-->

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE HTML>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
        <title>Cadastro de Usu�rios</title>
    </head>
    <body>
        <h1>Cadastro de Usu�rios</h1>

        <c:choose>
            <c:when test="${empty lista}">
                <p>- N&atilde;o h&aacute; usu�rios registrados </p>
            </c:when>
            <c:otherwise>

                <table>
                    <caption>Tabela com usu�rios cadastrados</caption>
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Login</th>
                            <th>Opcoes</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="user" items="${lista}">
                            <tr>
                                <td>${user.nome} </td>
                                <td>${user.login} </td>
                                <td> <a href="${pageContext.request.contextPath}/excluir?id=<c:out value="${user.id}"/>">Excluir</a>
                                     <a href="${pageContext.request.contextPath}/Telaeditar?id=<c:out value="${user.id}"/>">Editar</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="3">Total de contatos: ${fn:length(lista)}</td>
                        </tr>
                    </tfoot>
                </table>

            </c:otherwise>
        </c:choose>

        <p>
            <a href="${pageContext.request.contextPath}/novo">Cadastrar novo Usu�rio</a>
            <a href="${pageContext.request.contextPath}/inicio">Voltar � p�gina inicial</a>
        </p>
    </body>
</html>
