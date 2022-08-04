create table user
(
	id int unsigned auto_increment
		primary key,
	name varchar(15) default '' not null,
	deleted tinyint unsigned default 0 not null comment '1是被删除，0是未删除',
	constraint user_name_uindex
		unique (name)
);