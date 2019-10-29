create table member_web(
	id varchar2(100) primary key,
	pw varchar2(100) not null,
	name varchar2(100)	
)

drop table member_web

insert into member_web values('admin','1q2w3e4r','°ü¸®ÀÚ')

select * from member_web