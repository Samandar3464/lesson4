create table  posta(
    id bigserial primary key ,
    title varchar,
    authorId bigint references author(id)
)