--V2: Migrations para adicionar a coluna rank na tabela de ninja
ALTER TABLE ninja
ADD COLUMN rank VARCHAR(50);