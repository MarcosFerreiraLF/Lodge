<%-- 
    Document   : editar
    Created on : 14/11/2018, 22:19:25
    Author     : 201619030438
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
        <title>Editar usuário</title>
    </head>
    <body>
        <h1>Formulário de edição de Usuário</h1>
        <form method="POST" action="${pageContext.request.contextPath}/editar">
            <p>Nome: <input type="text" name="nome" size="40"></p>
            <p>Login: <input type="text" name="login" size="40"></p>            
            <p>Senha: <input type="password" name="senha" size="10"></p>
            <p><input type="submit" value="Salvar">
                <input type="reset" value="Limpar"></p>
        </form>
    </body>
</html>
