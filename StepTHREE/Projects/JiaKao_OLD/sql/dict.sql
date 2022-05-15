CREATE DATABASE jiakao_v1 CHARACTER SET utf8mb4;

USE jiakao_v1;

/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022-05-05 23:16:43                          */
/*==============================================================*/


drop table if exists dict_item;

drop table if exists dict_type;

/*==============================================================*/
/* Table: dict_item                                             */
/*==============================================================*/
create table dict_item
(
    id                   bigint not null,
    name                 varchar(20) not null,
    value                varchar(20) not null,
    no                   int not null default 0 comment '用来排序，数字越小，优先级越高，越先展示',
    type_id              bigint comment '该条目所属的数据字典类型',
    status               int not null default 1 comment '是否启用该条目，0：不启用，1：启用',
    primary key (id),
    unique key AK_UK_1 (name, type_id),
    unique key AK_UK_2 (value, type_id)
);

alter table dict_item comment '数据字典每一项具体的内容';

/*==============================================================*/
/* Table: dict_type                                             */
/*==============================================================*/
create table dict_type
(
    id                   bigint not null auto_increment,
    name                 varchar(20) not null comment '名称是展示在客户端的，是有可能会发生改变的',
    value                varchar(20) not null comment '值不会发生改变，编写SQL操作数据时，一般使用value而不是name',
    intro                varchar(100) comment '防止程序员忘记该数据字典类型的作用、功能（根据项目需求可有可无）',
    primary key (id),
    unique key AK_UK_1 (name),
    unique key AK_UK_2 (value)
);

alter table dict_type comment '数据字典类型';

alter table dict_item add constraint FK_Reference_1 foreign key (type_id)
    references dict_type (id) on delete restrict on update restrict;