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
        <link href="css/syleHome.css" rel="stylesheet" type="text/css"/>
        <title>Login</title>
         <title>Lodge</title>
        <script>
            function validateLogin() {
                if (${cliente} === null) {
                    alert("Você deve estar logado para ver suas reservas!");
                    return false;
                }
            }
        </script>
    </head>

          <!---Inicio do corpo do página home--->
    <body>
         <header>
            <c:choose>
                <c:when test="${cliente==null}">
                    <p>Bem vindo, visitante      <a class="active" href="${pageContext.request.contextPath}/logar">Login/Registrar</a></p>
                </c:when>
                <c:otherwise>
                    <p>Bem vindo, ${cliente.nome}      <a href="${pageContext.request.contextPath}/logout">Sair</a></p>
                </c:otherwise>
            </c:choose>
        </header>

        <div class="principal">
            <div class="wrap">
                <div class="topo">
                    <!---Adciona o logo no topo da página--->
                    <div class="logo">
                        <a href="${pageContext.request.contextPath}/inicio"><img src="imagens/logo.jpg" title="logo"/></a>
                    </div>

                    <!---Inicio do corpo do página home--->
                    <div class="info">
                        <p class="telefone"> CONTATE-NOS : <a href="#">67-3346-0000</a><p/>
                        <p class="email"> EMAIL :<a href="#">LODGER@GMAIL.COM</a></p>
                        <p class="slogan"> COMPRE SUA RESERVA JÁ! </p>
                    </div>
                    <!---Divisoria Estética--->
                    <div class="espaco"></div>
                </div>
            </div>
            <!---Navegação do topo da página--->
            <div class="navedor-topo">
                <div class="wrap1">
                    <ul>
                        <li><a href="${pageContext.request.contextPath}/logar">Login/Registrar</a></li>
                        <li><a href="${pageContext.request.contextPath}/lista">Busca Hoteis</a></li>
                        <li><a href="${pageContext.request.contextPath}/listarReservas " onclick="return validateLogin()">Suas Reservas</a></li>

                    </ul>

                </div>
            </div>

   
       <div class="form-content">
		<form action="${pageContext.request.contextPath}/efetuaLogin" method="post">
			<div class="form-info">
				<h2>LOGIN</h2>
			</div>
			<div class="email-w3l">
				<span class="i1"><i class="fa fa-envelope-o" aria-hidden="true"></i></span>
				<input class="email" type="text" name="email" placeholder="Email/login" required="">
			</div>
			<div class="pass-w3l">
			<!---728x90--->
			<span class="i2"><i class="fa fa-unlock" aria-hidden="true"></i></span>
				<input class="pass" type="password" name="password" placeholder="Senha" required="">
			</div>
			<div class="form-check">
				<div class="left">
					<input type="checkbox" value="Remember me">Lembre-me
				</div>
				<div class="right">
					<a href="${pageContext.request.contextPath}/novo">Não Registrado?</a>
				</div>
				<div class="clear"></div>
			</div>
			<div class="submit-agileits">
				<input class="login" type="submit" value="logar">
			</div>
		</form>
	</div>
            
        </div>
        
        <div class="content-grids">
            <div class="wrap">
                <div class="content-grid">
                    <div class="content-grid-pic">
                        <a href="#"><img src="imagens/icon1.png" title="image-name"/></a>
                    </div>
                    <div class="content-grid-info">
                        <h3>CAFÉ DA MANHÂ INCLUSO</h3>
                        <p> BRINDE DO NOSSO SITE NA PRIMEIRA COMPRA </p>
                    </div>
                    <div class="espaco"></div>
                </div>
                <div class="content-grid">
                    <div class="content-grid-pic">
                        <a href="#"><img src="imagens/icon2.png" title="image-name" /></a>
                    </div>
                    <div class="content-grid-info">
                        <h3>SUPORTE  POR TELEFONE DAS 8:00 ÀS 22:00</h3>
                        <p> DÚVIDAS - RECLAMAÇOES </p>
			
                    </div>
                    <div class="clear"> </div>
                </div>
                <div class="content-grid">
                    <div class="content-grid-pic">
                        <a href="#"><img src="imagens/iocn3.png" title="image-name" /></a>
                    </div>
                    <div class="content-grid-info">
                        <h3>OS MELHORES SERVIÇOS PARA VOCÊ</h3>
                         <p> AQUI VOCÊ ENCONTRA OS MELHORES HOTÉIS
                             COM OS MELHORES PRATOS </p>
                        
                    </div>
                        <div class="clear"> </div>
                </div>
                    <div class="clear"> </div>
            </div>
        </div>
    </body>
</html>
