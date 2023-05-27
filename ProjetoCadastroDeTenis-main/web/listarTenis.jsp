<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp"/>
<div class="card text-center">
    <div class="card-header">
        <h1>Tênis</h1>
        <hr/>
        <div class="row">
            <div class="col-12">
                <a href="NovoTenis" class="btn btn-primary" style="background-color: #0000FF; color: white; border: 1px solid black;">Novo Tênis</a>
                <a href="${pageContext.request.contextPath}/home.jsp" class="btn btn-primary" 
                   style="background-color: #FF0000; color: white; border: 1px solid black;">Voltar</a>


            </div>
        </div>
        <hr/>
        <c:if test="${mensagem != null}">
            <div class="alert alert-primary" role="alert">
                ${mensagem}
            </div>
        </c:if>
    </div>
    <div class="card-body">
        <table class="table">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th>Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="tenis" items="${Tenis}">
                    <tr>
                        <td>${tenis.codigoTenis}</td>
                        <td>${tenis.nomeTenis}</td>
                        <td>${tenis.marca.nomeMarca}</td>
                        <td><a class="btn btn-info" href="ConsultarTenis?codigoTenis=${tenis.codigoTenis}">Alterar</a>
                    </tr>

                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="rodape.jsp"/>