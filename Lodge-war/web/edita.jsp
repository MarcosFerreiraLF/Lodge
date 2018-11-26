<%-- 
    Document   : edita
    Created on : 11/11/2018, 23:35:53
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
        <title>Formulário de edição</title>
    </head>
    <body>
        <h1>Formulário de edição de Usuário</h1>
        <form method="POST" action="${pageContext.request.contextPath}/editar?id=${usuario.getId()}">



            <p>Nome: <input type="text" name="nome" size="40" required="required"
                            value="${usuario.getNome()}"></p>
            <p>Login: <input type="text" name="login" size="40"required="required"
                             value="${usuario.getLogin()}"></p>            
            <p>Senha: <input type="password" name="senha" size="10"></p>
            <p><input type="submit" value="Salvar">
                <input type="reset" value="Limpar"></p>
        </form>
    </body>
</html>
