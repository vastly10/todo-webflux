create table if not exists TODO (
    id int primary key auto_increment,
    title varchar not null,
    completed boolean not null,
    reg_time timestamp not null,
    mod_time timestamp
);
