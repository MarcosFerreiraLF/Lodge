<%-- 
    Document   : login
    Created on : 01/12/2018, 19:35:32
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo2.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h2>Página de Login </h2>
              <form action="efetuaLogin" method="post">
                  Login: <input type="text" name="nome" /> <br /> 
                  Senha: <input type="password" name="senha" /> <br />
                  <input type="submit" value="logar" /> 
              </form>
        
        <p>
           
            <a href="${pageContext.request.contextPath}/inicio">Voltar à página inicial</a>
        </p>
    </body>
</html>
