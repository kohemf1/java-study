--테이블 삭제
drop table rent;
drop table member;
drop table car;
drop table manager;

--데이터 삭제
delete from member;
delete from car;
delete from manager;
delete from rent;
--member table 생성
create table member(
membercode number(4) constraint member_membercode_pk primary key,
id varchar2(20) constraint member_id_uk unique not null,
pw varchar2(20) not null,
name varchar2(20) not null,
carreg varchar2(14) constraint member_carrg_uk unique not null,
email varchar2(40) not null,
address varchar2(40) not null
)
;
--car 테이블 생성
create table car(
carcode number(4) constraint car_carcode_pk primary key,
carnumber varchar2(20) constraint car_cnum_uk unique not null,
carname varchar2(20) not null,
carsize varchar2(10) not null,
carseat number(2) not null,
caryear number(4) not null,
fuel varchar2(20) not null,
rentck number(1) constraint car_rentck_ck check(rentck between 0 and 1) not null

-- rent 는 대여현황을 체크하기 위한 컴럼으로 
-- 0 이면 대여가 가능한 상태임을 나타내고 1이면 대여중임을 나타낸다
)
;
--manager 테이블 생성
create table manager(
managercode number(4) constraint manager_managercode_pk primary key,
mid varchar2(20) not null,
mpw varchar2(20) not null
);
--manager 데이터 입력
insert into manager values(1,'admin','1234');

--rent table 생성 
create table rent(
rentcode number(4) constraint rent_rentcode_pk primary key,
pay number(6) not null,
rentperiod number(1) constraint rent_period_ck check(rentperiod between 1 and 3)  not null,
rent_date date default sysdate , --대여 날짜
carcode number constraint rent_carcode_fk REFERENCES car(carcode) on delete cascade not null,
membercode number constraint rent_membercode_fk REFERENCES member(membercode) on delete cascade constraint rent_membercode_uk unique not null,
managercode number constraint rent_managercode_fk REFERENCES manager(managercode) on delete cascade
);
insert into rent values(rent_rentcode_seq.nextval,10000,3,sysdate+3,(select carcode from car where carnumber = 3333),(select membercode from member where carreg = 1113),1);


--------------------------------
create table pay(
paycode number(4) constraint manager_managercode_pk primary key,
charge number(8),
membercode number constraint rent_membercode_fk REFERENCES member(membercode) on delete cascade constraint rent_membercode_uk unique not null
);

create table paylist(



)
;

create table amugua1(
a number(2),
b number(2),
c number(3)
)
;
insert into values(5,5, a*b);
--------------------------------
select c.carname, r.rent_date, r.pay , r.rentperiod from car c, member m, rent r
where 
m.membercode = ( select membercode from member where id = 'm1')
and m.membercode = r.membercode and r.carcode = c.carcode
;

update car set rentck = 0 where carcode = 2 or carcode = 1 ;

select * from car;
select * from rent;
select * from member;

delete from rent natural join car on carnumber = '1111';
delete from rent
where carcode = (select carcode from car where carnumber = '1111');


--고객 렌트 정보
select r.pay, r.rentperiod,r.rent_date   from car c, member m, rent r
where m.membercode = ( select membercode from member where id = 'm1')
and m.membercode = r.membercode and r.carcode = c.carcode
;

select * from rent_info 
where membercode = ( select membercode from member where id = 'm1');

insert into rent values(rent_rentcode_seq.nextval,10000,3,sysdate+3,(select carcode from car where carnumber = 3333),(select membercode from member where carreg = 1113),1,1);
select * from rent ;
select to_char(rent_date, 'yyyy-mm-dd hh24:mi:ss') from rent;
select * from rent;
--데이터 출력
desc member;
desc rent;



select *
from car natural join rent;

create or replace view rent_info
as

select *
from rent r natural join car c;

select * from rent_info;

drop view rent_info;

select *
from rent;

update rent_info
set rent = 1
where carcode = 1;


--member 시퀀스 생성
CREATE SEQUENCE member_membercode_SEQ
INCREMENT BY 1
START WITH 1;
-- member 시퀀스 삭제
delete from member_membercode_seq;

--car 시퀀스 생성
CREATE SEQUENCE car_carcode_SEQ
INCREMENT BY 1
START WITH 1;
-- car 시퀀스 삭제
drop sequence car_carcode_seq;

--rent 시퀀스 생성
CREATE SEQUENCE rent_rentcode_SEQ
INCREMENT BY 1
START WITH 1;
--rent 시퀀스 삭제
drop sequence rent_rentcode_seq;

--id 컬럼 삭제
alter table member
drop column id;

alter table member
add unique (id);

--member 데이터 입력
insert into member values
(1, 'member2', '123456', '흥민', '22222', 'member1@naver.com', 'SEOUL');
--member 데이터 삭제
delete from member;
-- member 테이블 삭제
drop table member;


insert into car values(CAR_CARCODE_SEQ.nextval, '2222', 'RAY', 'big', 5, 2018, '가솔린','1');
insert into car values(CAR_CARCODE_SEQ.nextval, '4444', 'lambo', 'small', 2, 2021, '디젤','0');
--car 데이터 삭제
delete from car;



-- 데이터 보기
desc manager;
select * from manager;
--데이터 입력
insert into manager values(1, 'admin', '1234');
--manager 시퀀스 생성
CREATE SEQUENCE manager_mncode_SEQ
INCREMENT BY 1
START WITH 1;
--manager 시퀀스 삭제
drop sequence manager_mncode_seq;

-----------------------------------------------------

--rent 테이블 생성 


--데이터 저장
insert into rent values(rent_rentcode_seq.nextval,10000,2,car_carcode_seq.nextval,member_mcode_seq.nextval,1 );
--테이블 삭제
drop table rent;
--foreign key 삭제하고 
alter table rent drop constraint rent_ccode_fk;
alter table rent drop constraint rent_memcode_fk;
alter table rent drop constraint rent_manacode_fk;
--on delete cascade 제약사항 추가 sql
alter table rent add constraint rent_ccode_fk FOREIGN key (carcode) REFERENCES car(carcode) on delete cascade;
alter table rent add constraint rent_memcode_fk FOREIGN key (membercode) REFERENCES member(membercode) on delete cascade;
alter table rent add constraint rent_manacode_fk FOREIGN key (managercode) REFERENCES manager(managercode) on delete cascade;









--커밋
commit;