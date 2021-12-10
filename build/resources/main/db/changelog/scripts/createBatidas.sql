--liquibase formatted sql

--changeset tpontes-1
create table momento (
    id int primary key,
    dataHora varchar(255)
);
--rollback drop table momento;