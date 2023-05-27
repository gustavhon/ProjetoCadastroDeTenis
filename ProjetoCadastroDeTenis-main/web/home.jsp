<%@page contentType="text/html" pageEncoding="UTF-8"%>
<head>
    <style>
        a[href="ListarTenis"],
        a[href="ListarMarca"],
        a[href="EfetuarLogout"] {
            outline: none;
            border: none !important;
        }
        
        a[href="ListarTenis"] {
            background-color: #0000FF !important;
        }
        a[href="ListarMarca"] {
            background-color: #00FF00 !important;
        }
        a[href="EfetuarLogout"] {
            background-color: #FF0000 !important; 
        }
    </style>
</head>
<body>
    <jsp:include page="cabecalho.jsp"/>
    <div class="card text-center">
        <div class="card-header">
            <h1>Menu principal</h1>
        </div>
        <div class="card-body">
            <a href="ListarTenis" class="btn btn-primary">Tênis</a>
            <a href="ListarMarca" class="btn btn-primary">Marcas</a>
            <a href="EfetuarLogout" class="btn btn-primary">Sair</a>
        </div>
    </div>
    <jsp:include page="rodape.jsp"/>
</body>
