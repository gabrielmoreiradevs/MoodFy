ALTER TABLE tb_contents
ALTER COLUMN rating TYPE double precision USING rating::double precision;