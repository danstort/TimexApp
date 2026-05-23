create table users (
    id uuid primary key,
    email varchar(255) not null unique,
    display_name varchar(80) not null,
    created_at timestamp with time zone not null
);
