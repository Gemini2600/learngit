create database eighth;
use eighth;
create table if not exists account(
	id int primary key auto_increment,
	username varchar(30) not null,
	password varchar(30) not null,
	ip varchar(30) not null,
	logindate bigint(100)
);
insert into account values(1,'admin','admin','127.0.0.1',now());