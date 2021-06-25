--OopMiniProject

create table member(
membercode number(4) constraint member_mmcode_pk primary key,
id varchar2(20) not null,
pw varchar2(20) not null,
name varchar2(20) not null,
carreg varchar2(14) not null,
email varchar2(40) not null,
address varchar2(40) not null
)
;

CREATE SEQUENCE member_membercode_SEQ
INCREMENT BY 1
START WITH 1;

insert into member values
(MEMBER_MEMBERCODE_SEQ.nextval, 'member1', '123456', '손흥민', '123456-1234567', 'member1@naver.com', 'SEOUL');
insert into member values
(MEMBER_MEMBERCODE_SEQ.nextval, 'member2', '123456', '케인', '234567-1345678', 'member2@google.com', 'PUSAN');
insert into member values
(MEMBER_MEMBERCODE_SEQ.nextval, 'member3', '123456', '모우라', '345678-1456789', 'member3@daum.net', 'DAEJEON');
insert into member values
(MEMBER_MEMBERCODE_SEQ.nextval, 'member4', '123456', '알리', '456789-1567890', 'member4@naver.com', 'JEJU');
insert into member values
(MEMBER_MEMBERCODE_SEQ.nextval, 'member5', '123456', '베일', '567890-1678901', 'member5@google.com', 'SEOUL');


create table car(
carcode number(4) constraint car_carcode_pk primary key,
carnumber varchar2(20) not null,
carname varchar2(20) not null,
carsize varchar2(10) not null,
carseat number(2) not null,
caryear number(4) not null,
fuel varchar2(20) not null,
rent char(1) constraint car_rent_ck check(rent = '0' or rent = '1') 
-- rent 는 대여현황을 체크하기 위한 컴럼으로 
-- 0 이면 대여가 가능한 상태임을 나타내고 1이면 대여중임을 나타낸다
)
;


insert into car values(car_carcode_SEQ.nextval, '1111', 'RAY', 'SMALL', 5, 2017, '가솔린','1');
insert into car values(car_carcode_SEQ.nextval, '2222', 'NIRO EV', 'SMALL', 5, 2022, '전기','1');
insert into car values(car_carcode_SEQ.nextval, '3333', 'SONATA', 'MIDDLE', 5, 2020, '가솔린','1');
insert into car values(car_carcode_SEQ.nextval, '4444', 'MODEL3', 'MIDDLE', 5, 2020, '전기','1');
insert into car values(car_carcode_SEQ.nextval, '5555', 'BMW X7', 'BIG', 7, 2020, '가솔린','1');
insert into car values(car_carcode_SEQ.nextval, '6666', 'CARNIVAL', 'BIG', 9, 2021, '가솔린','1');

CREATE SEQUENCE car_carcode_SEQ
INCREMENT BY 1
START WITH 1;


create table manager(
managercode number(4) constraint mcode_mcode_pk primary key,
mid varchar2(20) not null,
mpw varchar2(20) not null
)
;

insert into manager values(manager_managercode_SEQ.nextval, 'manager1', '123123');
insert into manager values(manager_managercode_SEQ.nextval, 'manager2', '321321');



CREATE SEQUENCE manager_managercode_SEQ
INCREMENT BY 1
START WITH 1;

-----------------------------------------------------
create table rent(
rentcode number(4) constraint rent_rcode_pk primary key,
pay INTEGER not null,
rentperiod number(1) not null,
carcode number constraint rent_carcode_fk REFERENCES car(carcode),
membercode number constraint rent_memcode_fk REFERENCES member(membercode),
managercode number constraint rent_manacode_fk REFERENCES manager(managercode)
)
;


CREATE SEQUENCE rent_rentcode_SEQ
INCREMENT BY 1
START WITH 1;


create table pay(
paycode number(4) constraint pay_pcode_pk primary key,
price number(10) not null unique,
period number(1) check(period between 1 and 3) not null
)
;

insert into pay values(
pay_paycode_seq.nextval, 5000 , 3
)
;

desc car;
select * from car;
select * from pay;

create sequence pay_paycode_seq;

-------------------------------
--select * from car;
--select * from memeber;
--select * from manager;
--select * from rent;
--drop table rent;
--drop table car;
--drop table member;
--drop table manager;
--drop sequence manager_managercode_seq;
--drop sequence member_membercode_seq;
--drop sequence Car_carcode_seq;
--drop sequence rent_rentcode_seq;
-----------------------------------------------------