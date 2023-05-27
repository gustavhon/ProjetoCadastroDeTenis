<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/cabecalho.jsp"/>
<div class="card text-center">
    <div class="card-header">
        <h1>Marcas</h1>
    </div>
    <div class="card-body">
        <c:if test="${mensagem != null}">
            <div class="alert alert-primary text-center" role="alert">
                ${mensagem}
            </div>
        </c:if>
        <hr/>
        <a class="btn btn-success" href="NovaMarca" style="background-color: #006400; border: 1px solid black; color: #ffffff;">Nova</a>
        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/home.jsp" style="background-color: #ff0000; border: 1px solid black; color: #ffffff;">Voltar</a>

        <hr/>
        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>Código</th>
                    <th>Nome</th>
                    <th colspan="2">Ações</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="marca" items="${marcas}">
                    <tr>
                        <td>${marca.codigoMarca}</td>
                        <td>${marca.nomeMarca}</td>
                        <td><a class="btn btn-info" href="ConsultarMarca?codigoMarca=${marca.codigoMarca}">Alterar</a></td>
                        <td><a class="btn btn-danger" href="ExcluirMarca?codigoMarca=${marca.codigoMarca}">Excluir</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<jsp:include page="rodape.jsp"/>