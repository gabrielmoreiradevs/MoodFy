CREATE TABLE contents_moods (
                                contents_id INTEGER,
                                moods_id INTEGER,
                                CONSTRAINT fk_contents_moods_contents FOREIGN KEY (contents_id) REFERENCES tb_contents(id),
                                CONSTRAINT fk_contents_moods_moods FOREIGN KEY (moods_id) REFERENCES tb_moods(id)
);
