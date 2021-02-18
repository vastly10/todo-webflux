create table if not exists TODO (
    id int primary key,
    title varchar not null,
    completed boolean not null,
    reg_time timestamp not null,
    mod_time timestamp
);

CREATE SEQUENCE TODO_ID_SEQ
START WITH 1
INCREMENT BY 1;
