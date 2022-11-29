-- sys 최고 관리자 계정에서 계정과 권한 생성
create user jsppsy identified by 1234;
grant connect, resource to jsppsy;
grant create view to jsppsy;

-- 회원 테이블 생성
create table member (
id varchar2(30) primary key,
password varchar2(30),
name varchar2(30),
gender varchar2(9),
birth date,
nickname varchar2(30),
introduce varchar2(300));

insert into member(id, password, name, gender, birth, nickname, introduce)
values('admin', '1234', '홍길동', '남',to_date(19990101, 'yyyy-mm-dd'),'hong','안녕하세요.');
commit;

