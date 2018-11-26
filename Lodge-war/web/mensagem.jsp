<!--
    Material utilizado para as aulas práticas das disciplinas da Faculdade de
Computação da Universidade Federal de Mato Grosso do Sul (FACOM / UFMS).
Seu uso é permitido para fins apenas acadêmicos, todavia mantendo a
referência de autoria.
    Created on : 25/10/2010
    Author     : Profª Jane Eleutério
-->

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
        <title>Cadastro de Usuários</title>
    </head>
    <body>
        <h1>Cadastro de Usuários</h1>

        <p>${mensagem}</p>

        <a href="${pageContext.request.contextPath}/lista">Lista de Usuários</a>
        <a href="${pageContext.request.contextPath}/inicio">Voltar à página inicial</a>
    </body>
</body>
</html>
