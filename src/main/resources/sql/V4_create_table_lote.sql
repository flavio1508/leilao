CREATE TABLE lote (
    id SERIAL PRIMARY KEY,
    numeroLote INTEGER,
    descricao VARCHAR(60) NOT NULL,
    quantidade NUMERIC NOT NULL,
    valorInicial NUMERIC,
    unidade VARCHAR(128) NOT NULL,
    leilao INTEGER,
    createdAt TIMESTAMP NOT NULL,
    updatedAt TIMESTAMP NOT NULL,
    FOREIGN KEY (leilao) REFERENCES leilao(id)
);