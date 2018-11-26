<!--
    Material utilizado para as aulas práticas das disciplinas da Faculdade de
Computação da Universidade Federal de Mato Grosso do Sul (FACOM / UFMS).
Seu uso é permitido para fins apenas acadêmicos, todavia mantendo a
referência de autoria.
    Created on : 25/10/2010
    Author     : Profª Jane Eleutério
-->

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE HTML>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
        <title>Cadastro de Usuários</title>
    </head>
    <body>
        <h1>Cadastro de Usuários</h1>

        <c:choose>
            <c:when test="${empty lista}">
                <p>- N&atilde;o h&aacute; usuários registrados </p>
            </c:when>
            <c:otherwise>

                <table>
                    <caption>Tabela com usuários cadastrados</caption>
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
            <a href="${pageContext.request.contextPath}/novo">Cadastrar novo Usuário</a>
            <a href="${pageContext.request.contextPath}/inicio">Voltar à página inicial</a>
        </p>
    </body>
</html>
