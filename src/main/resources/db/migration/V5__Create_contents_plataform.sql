CREATE TABLE contents_plataforms (
                                     contents_id INTEGER,
                                     plataforms_id INTEGER,
                                     CONSTRAINT fk_contents_plataforms_contents
                                         FOREIGN KEY (contents_id) REFERENCES tb_contents(id),
                                     CONSTRAINT fk_contents_plataforms_plataforms
                                         FOREIGN KEY (plataforms_id) REFERENCES tb_plataform(id)
);