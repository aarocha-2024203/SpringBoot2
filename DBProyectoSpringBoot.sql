drop database if exists DBProyectoSpringBoot;
create database DBProyectoSpringBoot;
use DBProyectoSpringBoot;
Create table user(
id int not null,
firstName varchar(15) not null,
lastName varchar(200) not null,
primary key PK_id(id)
);