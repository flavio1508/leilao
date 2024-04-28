CREATE TABLE empresa (
    id SERIAL PRIMARY KEY,
    razaoSocial VARCHAR(64) NOT NULL,
    cnpj VARCHAR(32) NOT NULL,
    logradouro VARCHAR(64),
    municipio VARCHAR(64),
    numero VARCHAR(10),
    complemento VARCHAR(64),
    bairro VARCHAR(64),
    cep VARCHAR(16),
    telefone VARCHAR(32),
    email VARCHAR(254) NOT NULL,
    site VARCHAR(254),
    usuario VARCHAR(20) NOT NULL,
    senha VARCHAR(128),
    createdAt TIMESTAMP NOT NULL,
    updatedAt TIMESTAMP NOT NULL
);