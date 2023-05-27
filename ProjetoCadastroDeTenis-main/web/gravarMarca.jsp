<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <style>
            .btn-vermelho {
                background-color: red !important;
                color: white !important;
            }
        </style>
        <style>
            .btn-azul {
                background-color: blue !important;
                color: white !important;
            }
        </style>
        <script>
            var gifArray = ['imagens/nike.gif', 'imagens/adidas.gif'];
            var counter = 0;

            function changeGif() {
                var gifElement = document.getElementById('dynamic-gif');
                gifElement.src = gifArray[counter];
                counter = (counter + 1) % gifArray.length;
            }

            var colorArray = ['red', 'blue', 'green', 'orange'];
            var colorCounter = 0;

            function changeColor() {
                var titleElement = document.getElementById('dynamic-color');
                titleElement.style.color = colorArray[colorCounter];
                colorCounter = (colorCounter + 1) % colorArray.length;
            }

            window.onload = function () {
                setInterval(changeGif, 5000); // change gif every 5 seconds
                setInterval(changeColor, 1000); // change color every second
            }
        </script>
    </head>
    <body>
        <jsp:include page="/cabecalho.jsp"/>
        <div class="card">
            <div class="card-header text-center">
                <img id="dynamic-gif" src="imagens/nike.gif" style="width: 250px; height: 150px; object-fit: cover;"/>
                <h1 id="dynamic-color">Gravar Marca de Tênis</h1>
            </div>
            <div class="card-body">
                <c:if test="${mensagem != null}">
                    <div class="alert alert-primary text-center" role="alert">
                        ${mensagem}
                    </div>
                </c:if>
                <form action="GravarMarca" method="post">
                    <div class="row">
                        <div class="form-group col-6">
                            <label for="nomeMarca">Nome:</label>
                            <input class="form-control" type="text" id="nomeMarca" name="nomeMarca" placeholder="Nome" required value="${marca.nomeMarca}"/>
                        </div>
                        <div class="form-group col-6">
                            <label for="codigoMarca">Código:</label>
                            <input class="form-control" type="text" id="codigoMarca" name="codigoMarca" readonly value="${marca.codigoMarca == 0 ? "" : marca.codigoMarca}"/>
                        </div>
                    </div>
                    <div class="form-group text-center">
                        <div class="text-center">
                            <hr/>
                            <button class="btn btn-vermelho" type="submit">Gravar</button>
                            <a class="btn btn-azul" href="ListarMarca">Voltar</a>
                            <hr style="border-color: black;" />
                        </div>
                </form>
            </div>
        </div>
        <jsp:include page="rodape.jsp"/>
    </body>
</html>
