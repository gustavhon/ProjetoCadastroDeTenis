<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .underline-input .form-control {
                background: transparent;
                border: none;
                border-bottom: 2px solid #000;
                border-radius: 0;
                box-shadow: none;
            }

            .underline-input .form-control:focus {
                border-color: #007bff;
                box-shadow: none;
            }
            .card {
                background-color: white !important;
            }
            .btn-gradient {
                width: 300px;
                padding: 10px 20px;
                border: none;
                border-radius: 20px;
                cursor: pointer;
                font-size: 20px;
                color: #fff;
                background: linear-gradient(334deg, #6b97f7, #7525e2, #f7137e);
                background-size: 180% 180%;
                animation: gradient-animation 6s ease infinite;
                transition: 0.3s all ease-in-out;
            }

            /* Definição da animação do gradiente */
            @keyframes gradient-animation {
                0% {
                    background-position: 0% 50%;
                }
                50% {
                    background-position: 100% 50%;
                }
                100% {
                    background-position: 0% 50%;
                }
            }
            body {
                animation: gradient 5s infinite;
                background: linear-gradient(334deg, #6b97f7, #7525e2, #f7137e);
                background-size: 200% 200%;
            }

            @keyframes gradient {
                0% {
                    background-position: 0% 50%;
                }
                50% {
                    background-position: 100% 50%;
                }
                100% {
                    background-position: 0% 50%;
                }
            }
            @keyframes colorChange {
                0% {
                    border-color: red;
                }
                25% {
                    border-color: purple;
                }
                50% {
                    border-color: blue;
                }
                75% {
                    border-color: orange;
                }
                100% {
                    border-color: green;
                }
            }
            .animated-border {
                border: 3px solid;
                padding: 10px;
                animation: colorChange 2s infinite;
            }
            .w-15 {
                width: 25% !important;
            }
            #nomeUsuario, #senhaUsuario {
                background-repeat: no-repeat;
                background-position: 98%;
                background-size: 20px 20px;
                padding-right: 30px;
            }
            #nomeUsuario {
                background-image: url('imagens/usuario.png');
            }
            #senhaUsuario {
                background-image: url('imagens/senha.png'); /* Substitua pelo caminho da sua imagem */
            }

        </style>
    </head>
    <body>
        <jsp:include page="cabecalho.jsp"/>
        <c:if test="${mensagem != null}">
            <div class="alert alert-primary text-center" role="alert">
                ${mensagem}
            </div>
        </c:if>
        <div class="card w-15 mx-auto my-5 animated-border">
            <div class="card-header text-center">
                <h1>Login</h1>
                <form action="EfetuarLogin" method="POST">
                <div class="row mt-3">
                    <div class="col-12 underline-input">
                        <label for="nomeUsuario">Usuário</label>   
                        <input type="text" class="form-control" id="nomeUsuario" name="nomeUsuario">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12 underline-input">
                        <label for="senhaUsuario">Senha</label>
                        <input type="password" class="form-control" id="senhaUsuario" name="senhaUsuario">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label for="perfilUsuario">Perfil:</label>
                        <select id="perfilUsuario" name="perfilUsuario" class="form-control">
                            <option value="">Selecione...</option>
                            <option value="01">Administrador</option>
                            <option value="02">Padrão</option>
                        </select>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12 text-center">
                        <button type="submit" class="btn btn-success btn-gradient" style="background-color: green;">Acessar</button>
                    </div>
                </div>
                </form>
            </div>
        </div>
        <jsp:include page="rodape.jsp"/>
    </body>
</html>
