CREATE TABLE comprador (
    empresa INTEGER,
    leilao INTEGER,
    PRIMARY KEY (empresa, leilao),
    FOREIGN KEY (empresa) REFERENCES empresa(id),
    FOREIGN KEY (leilao) REFERENCES leilao(id)
);