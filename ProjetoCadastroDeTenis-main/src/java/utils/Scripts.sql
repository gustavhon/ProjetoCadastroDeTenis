CREATE DATABASE aplicacao_tenis;

-- Tenis = {codigoTenis, nomeTenis, codigomarca}
CREATE TABLE Tenis(
    codigoTenis serial NOT NULL PRIMARY KEY,
    nomeTenis VARCHAR NOT NULL,
    codigomarca INT NOT NULL REFERENCES marca(codigomarca)    
);
--Marca ={codigoMarca, nomeMarca}
CREATE TABLE Marca(
    codigoMarca serial NOT NULL PRIMARY KEY,
    nomeMarca VARCHAR NOT NULL
);
--Usuario ={codigoUsuario, nomeUsuario, senhaUsuario, perfilUsuario, statusUsuario}
CREATE TABLE Usuario(
	codigoUsuario serial NOT NULL PRIMARY KEY,
	nomeUsuario VARCHAR NOT NULL,
	senhaUsuario VARCHAR NOT NULL,
	perfilUsuario VARCHAR,
        statusUsuario BOOLEAN NOT NULL
);


INSERT INTO Usuario(nomeUsuario, senhaUsuario, perfilUsuario, statusUsuario)
VALUES('Gustavo', '123', '01', true);
