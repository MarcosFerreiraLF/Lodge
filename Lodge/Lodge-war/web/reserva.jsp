<%-- 
    Document   : reserva
    Created on : 01/12/2018, 19:36:16
    Author     : mathe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reserva</title>
        <link rel="stylesheet" type="text/css" href="estilo2.css"/>
        <script>
            function validateForm() {
            onclick = "myFunction();
            }
            }
        </script>
    </head>
    <body>
        <h1>Reserva para o quarto ${quarto.numero} do ${estabelecimento.descricao}</h1>
        <p>Preço: ${quarto.preco}</p>
        <form name="reserva" method="POST" action="${pageContext.request.contextPath}/efetuarReserva?id=${quarto.id}"/>
            <p>Entrada: <input type="date" name="dt_ent"></p>
            <p>Saída: <input type="date" name="dt_sai"></p>
            <p>Pagamento:  <input type="radio" name="metodo" value="cartao" checked> Cartão   
                <input type="radio" name="metodo" value="boleto"> Boleto</p>
            <p>Número do cartão: <input type="text" name="cartao" size="40"></p>
            <p><input type="submit" value="reservar"></p>
        </form>
           
        <a href="${pageContext.request.contextPath}/inicio">Home</a>


      
    </body>
</html>