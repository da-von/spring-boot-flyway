
create table author
(
    id   bigserial not null
        constraint author_pkey
            primary key,
    artist_name varchar   not null,
    pre_name    varchar,
    family_name varchar
);

create table book
(
    id        bigserial not null
        constraint book_pkey
            primary key,
    author_id bigint    not null
        constraint fk_book_author
            references author,

    title     varchar   not null,
    isbn      varchar   not null,
    genre     varchar   not null
);

create unique index if not exists uc_book_isbn
    on book (isbn);
