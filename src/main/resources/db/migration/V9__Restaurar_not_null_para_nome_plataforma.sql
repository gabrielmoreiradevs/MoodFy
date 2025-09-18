UPDATE tb_plataform SET name = 'Nome não informado' WHERE name IS NULL;
ALTER TABLE tb_plataform ALTER COLUMN name SET NOT NULL;