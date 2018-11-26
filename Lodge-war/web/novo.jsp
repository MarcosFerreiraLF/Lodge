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
        <h1>Formulário de cadastro de Usuário</h1>
        <form method="POST" action="${pageContext.request.contextPath}/salva">
            <p>Nome: <input type="text" name="nome" size="40"></p>
            <p>Login: <input type="text" name="login" size="40"></p>            
            <p>Senha: <input type="password" name="senha" size="10"></p>
            <p><input type="submit" value="Salvar">
                <input type="reset" value="Limpar"></p>
        </form>
    </body>
</html>
