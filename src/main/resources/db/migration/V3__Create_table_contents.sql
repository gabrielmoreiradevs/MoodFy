CREATE TABLE tb_contents(
    id bigserial PRIMARY KEY,
    title varchar(100) NOT NULL,
    description text NOT NULL,
    release_date date,
    rating numeric,
    creation_date timestamp,
    update_date timestamp
)