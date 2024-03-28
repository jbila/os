CREATE DATABASE order_servico;
use order_servico;
drop table cliente;
CREATE TABLE cliente (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    contacto VARCHAR(20),
    email VARCHAR(100),
    data_criacao DATE,
	data_actualizacao DATE
);
drop table utilizador;
CREATE TABLE utilizador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100),
    status VARCHAR(20),
    perfil VARCHAR(20),
    data_criacao DATE,
    data_actualizacao DATE
);

CREATE TABLE ordem_servico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    equipamento VARCHAR(100),
    status VARCHAR(20),
    avaria TEXT,
    servico TEXT,
    tecnico VARCHAR(100),
    valor DECIMAL(10, 2),
    iva DECIMAL(10, 2),
    data DATE
);
SELECT * FROM utilizador;

