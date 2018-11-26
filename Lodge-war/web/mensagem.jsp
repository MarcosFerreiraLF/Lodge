<!--
    Material utilizado para as aulas pr�ticas das disciplinas da Faculdade de
Computa��o da Universidade Federal de Mato Grosso do Sul (FACOM / UFMS).
Seu uso � permitido para fins apenas acad�micos, todavia mantendo a
refer�ncia de autoria.
    Created on : 25/10/2010
    Author     : Prof� Jane Eleut�rio
-->

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML>

<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
        <title>Cadastro de Usu�rios</title>
    </head>
    <body>
        <h1>Cadastro de Usu�rios</h1>

        <p>${mensagem}</p>

        <a href="${pageContext.request.contextPath}/lista">Lista de Usu�rios</a>
        <a href="${pageContext.request.contextPath}/inicio">Voltar � p�gina inicial</a>
    </body>
</body>
</html>
