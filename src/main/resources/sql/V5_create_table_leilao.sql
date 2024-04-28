CREATE TABLE leilao (
    id SERIAL PRIMARY KEY,
    codigo INTEGER,
    descricao VARCHAR(60) NOT NULL,
    vendedor INTEGER NOT NULL,
    inicioPrevisto TIMESTAMP NOT NULL,
    createdAt TIMESTAMP NOT NULL,
    updatedAt TIMESTAMP NOT NULL
);