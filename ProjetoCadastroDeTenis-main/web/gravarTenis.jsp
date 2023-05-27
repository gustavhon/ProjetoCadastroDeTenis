<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="cabecalho.jsp"/>
<div class="card">
    <div class="card-header text-center">
        <h1>Novo Tênis</h1>
    </div>
    <div class="card-body">
        <c:if test="${mensagem != null}">
            <div class="alert alert-primary text-center" role="alert">
                ${mensagem}
            </div>
        </c:if>

        <form action="GravarTenis" method="post">
            <input class="form-control" type="text" id="codigoTenis" name="codigoTenis" readonly hidden value="${tenis.codigoTenis == 0 ? "" : tenis.codigoTenis}"/>
            <div class="row">
                <div class="form-group">
                    <label for="nomeTenis" class="form-label">Nome:</label>
                    <input type="text" id="nomeTenis" class="form-control rounded-pill" name="nomeTenis" value="${tenis.nomeTenis}" style="width: 50%;"/>
                </div>

                <div class="form-group col-4">
                    <label for="codigoMarca">Marca:</label>
                    <select id="codigoMarca" name="codigoMarca" class="form-control" required>
                        <option value="">Selecione...</option>
                        <c:forEach var="marca" items="${marcas}">
                            <option value="${marca.codigoMarca}" ${marca.codigoMarca == tenis.marca.codigoMarca ? "selected" : ""}>${marca.nomeMarca}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="row mt-3">
                    <div class="col-12 text-center">
                        <button type="submit" class="btn btn-success" style="background-color: #006400;">Cadastrar</button>
                        <a href="ListarTenis" class="btn btn-secondary" style="background-color: #FF0000; color: #ffffff;">Voltar</a>
                    </div>
                </div>
        </form>
    </div>
</div>
<jsp:include page="rodape.jsp"/>