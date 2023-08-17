
alter table author add column pre_name varchar;
alter table author add column family_name varchar;
alter table author rename column name to artist_name;

create unique index if not exists uc_book_isbn
    on book (isbn);
