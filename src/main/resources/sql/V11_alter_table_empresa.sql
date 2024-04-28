ALTER TABLE empresa
ADD CONSTRAINT empresa_cnpj_uk UNIQUE (cnpj);

ALTER TABLE empresa
ADD CONSTRAINT empresa_usuario_uk UNIQUE (usuario);