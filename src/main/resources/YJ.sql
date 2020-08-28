use YJ

create table UserTable(
user_number int,
user_name varchar(16),
email varchar(64) unique not null,
pw varchar(64) not null,
primary key(user_number)
)
SELECT count(*) FROM UserTable
select getdate()
SELECT * FROM UserTable

create table WriteTable(
post_number int primary key,
user_number int,
title Varchar(30) not null,
content Varchar(100) not null,
likes int not null,
hate int not null,
visit int not null,
posted_date DATETIME
foreign key (user_number) references UserTable(user_number) on delete cascade
)

insert into UserTable values
(1,'둘이','onepice@naver.com','1234')
insert into UserTable values
(2,'길동이','naruto@naver.com','1234')
insert into UserTable values
(3,'도우너','bleach@naver.com','1234')
insert into UserTable values
(4,'또치','onepunchman@naver.com','1234')

insert into WriteTable values
(1,1,'제목',' 컨텐츠 MaxLength 100 입니다.!@#$',0,0,0,'2020-08-18')
insert into WriteTable values
(2,1,'HeaderTest3','MaxLength 100 입니다.!@#$',0,0,0,'2020-08-18')

select * from UserTable
select * from WriteTable
drop table WriteTable
drop table UserTable

create table ImageTable (
	imageId int primary key identity,
	imageLocation varchar(512),
	post_number int,

	foreign key (post_number) references WriteTable(post_number)
)
