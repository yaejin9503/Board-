create table member1
(
	userid varchar2(20) primary key, 
	userpwd varchar2(20) not null, 
	username varchar2(30) not null, 
	phone varchar2(20) not null, 
	gender varchar2(10) default 'male', 
	email varchar2(50),
	address varchar2(100)
)

create table board(
	boardseq number primary key, 
	userid varchar2(20) references Member1(userid) not null,
	title varchar2(200),
	content varchar2(4000), 
	regdate date default sysdate, 
	viewcount number default 0, 
	favorite number default 0,  
	originalfile varchar2(500), 
	savedfile varchar2(500)
); 

create sequence board_seq


insert into board values(
	board_seq.nextval,
	'aaa',
	'¾È³ç',
	'¾È³ç¾È³ç¾È³ç',
	sysdate,
	0,
	0,
	'',
	''
)


