<%-- 
    Document   : cadastro
    Created on : 01/12/2018, 18:32:55
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="estilo2.css"/>
    </head>
    <body>
        <form method="POST" action="${pageContext.request.contextPath}/salva">
            <p>Nome: <input type="text" name="nome" size="40"></p>
            <p>Login: <input type="text" name="login" size="40"></p>            
            <p>Senha: <input type="password" name="senha" size="10"></p>
            <p>Endereco: <input type="text" name="endereco" size="40"></p>
             <p>DataNasc: <input type="Date" name="dataNasc" size="40"></p>
            <p><input type="submit" value="Salvar">
                <input type="reset" value="Limpar"></p>
        </form>
            
       <p>
           
            <a href="${pageContext.request.contextPath}/inicio">Voltar à página inicial</a>
        </p>       
    </body>
</html>
