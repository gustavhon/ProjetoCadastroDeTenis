<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Tênis</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
        <style>
        .header-container {
            height: 127.2px;  
            width: 1600px;   
            background: url('imagens/adidasyeezycabecalho.jpg') no-repeat center center;
            background-size: cover;  
        }

        #titulo-3d {
            text-shadow: -3px 3px 0px black;
        }

        /* Estilo para a borda */
        .border-below-header {
            width: 100%;  
            height: 0.5px; 
            background-color: black; 
        }

        </style>
    </head>
    <body>
        <header class="container-fluid bg-primary text-center text-white py-4 header-container">
            <h1 id="titulo-3d">Sistema Cadastro de Tênis</h1>
        </header>
        <!-- Adicione a borda aqui -->
        <div class="border-below-header"></div>
    </body>
</html>