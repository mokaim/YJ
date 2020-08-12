use YJ

create table UserTable(
ID varchar(12) unique not null,
PW varchar(20) not null,
NName varchar(12) not null,
Phone varchar(13) unique not null,
Email varchar(30) unique not null,
primary key(NName)
)

create table WriteTable(
NName varchar(12) not null,
Header Varchar(30) not null,
Content Varchar(100) not null,
Likes int not null,
Hate int not null,
Visit int not null,
foreign key (NName) references UserTable(NName) on delete cascade
)

insert into UserTable values
('ID1','1234','UniqeNick','010-1234-5678','emaisk@naver.com')
insert into UserTable values
('ID2','1234','QWER1234','010-5475-9458','asdwss@naver.com')
insert into UserTable values
('ID3','1234','ASDF1234','010-1254-7754','gsdfge@naver.com')
insert into UserTable values
('ID5','1234','XCVB124','010-6768-8444','123ssq@naver.com')

insert into WriteTable values
('UniqeNick','제목',' 컨텐츠 MaxLength 100 입니다.!@#$',0,0,0)
insert into WriteTable values
('UniqeNick','HeaderTest3','MaxLength 100 입니다.!@#$',0,0,0)

select * from UserTable
select * from WriteTable