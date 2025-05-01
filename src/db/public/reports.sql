create table reports
(
    id          integer generated always as identity
        constraint "Reports_pkey"
            primary key,
    name        varchar(255)      not null
        constraint "Reports_Name_key"
            unique,
    description varchar(255),
    group_id    integer default 0 not null
);

alter table reports
    owner to gloreus;

