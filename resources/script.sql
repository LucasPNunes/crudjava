CREATE database publico;

CREATE TABLE clientes(
    id_cliente INT NOT NULL auto_increment PRIMARY KEY,
    nome varchar(40),
    email varchar(50),
    idade int,
    dataCadastro date
)