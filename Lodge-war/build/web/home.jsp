<%-- 
    Document   : home
    Created on : 01/12/2018, 18:16:54
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estilo.css"/>
        
    </head>
    <body>
        <p>Bem vindo, ${usuario} <a href="${pageContext.request.contextPath}/logout">Sair</a></p> 
        <header> <h1>Lodge</h1> </header>
        
        <ul>
            <li><a class="active" href="${pageContext.request.contextPath}/logar">Login</a></li>
            <li><a href="${pageContext.request.contextPath}/busca">Busca Hoteis</a></li>
             <li><a href="${pageContext.request.contextPath}/novo">Cadastro</a></li>
             <li><a href="${pageContext.request.contextPath}/mostrarReservas">Suas Reservas</a></li>
            
        </ul>
    </body>
</html>
