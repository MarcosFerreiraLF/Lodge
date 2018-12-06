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
        <title>Cadastro</title>
        <link href="css/registro.css" rel="stylesheet" type="text/css"/>
    </head>
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
                        <p class="slogan">  COMPRE SUA RESERVA JÁ!</p>
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

            <div class="main-content-agile">
                <div class="sub-main-w3">
                    <form action="${pageContext.request.contextPath}/salva" method="post">
                        <h1 class="regitros">REGISTRE-SE</h1>
                        <div class="form-style-agile">
                            <label>Nome:</label>
                            <div class="pom-agile">
                                <span class="fa fa-key" aria-hidden="true"></span>
                                <input type="text" name="nome" size="40">
                            </div>
                        </div>
                        <div class="form-style-agile">
                            <label>CPF:</label>
                            <div class="pom-agile">
                                <span class="fa fa-key" aria-hidden="true"></span>
                                <input type="text" name="cpf" size="14" placeholder="000.000.000-00">
                            </div>
                        </div>
                        <div class="form-style-agile">
                            <label>lOGIN:</label>
                            <div class="pom-agile">
                                <span class="fa fa-key" aria-hidden="true"></span>
                                <input type="text" name="login" size="40">
                            </div>
                        </div>
                        <div class="form-style-agile">
                            <label>SENHA:</label>
                            <div class="pom-agile">
                                <span class="fa fa-key" aria-hidden="true"></span>
                                <p>Senha: <input type="password" name="senha" size="10"></p>
                            </div>
                        </div>

                        <div class="form-style-agile">
                            <label>ENDERECO:</label>
                            <div class="pom-agile">
                                <span class="fa fa-key" aria-hidden="true"></span>
                                <input type="text" name="endereco" size="40">
                            </div>
                        </div>
                        <div class="form-style-agile">
                            <label>SEXO:</label>
                            <div class="pom-agile">
                                <span class="fa fa-key" aria-hidden="true"></span>
                                <input type="radio" name="sexo" value="masculino" checked> Masculino   
                                <input type="radio" name="sexo" value="feminino"> Feminino</p>
                            </div>
                        </div>

                        <div class="form-style-agile">
                            <label>DATANASC:</label>
                            <div class="pom-agile">
                                <span class="fa fa-key" aria-hidden="true"></span>
                                <input type="date" name="dataNasc"></p>
                            </div>
                        </div>



                        <p><input type="submit" value="salva">
                            <input type="reset" value="limpar"></p>

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

    </body>
</html>
