-- 2021.06.24 
--sequence
-- member_membercode_seq
-- car_carcode_seq
--rent_rentcode_seq
desc member;
desc rent;
desc car;
--데이터 보기
select * from car;
select * from member;
select * from manager;
select * from rent;

 
--시퀀스의 값 1로 지정
alter sequence member_membercode_seq increment by 1;
alter sequence car_carcode_seq increment by 1;
alter sequence rent_rentcode_seq increment by 1;

--member table 데이터 추가
insert into member values (member_membercode_seq.nextval, 'member2', '123456', '손흥민', '1113', 'member1@naver.com', 'SEOUL');
--car table 데이터 추가
insert into car values(CAR_CARCODE_SEQ.nextval, '3333', 'RAY', 'big', 5, 2018, '가솔린','0');
--rent table 데이터 추가
insert into rent values(rent_rentcode_seq.nextval,10000,2,(select carcode from car where carnumber = 1111),(select membercode from member where carreg = 1111),1);
select * from member where membercode = (select membercode from rent);
select * from car
where rent != 1
;

select * from rent;

-- 대여완료시 -> 렌트 코드가 생성되면서 렌트 정보가 나타나게 

desc rent;

select to_char(sysdate+1, 'yyyy-mm-dd hh24:mi:ss')
from dual;



commit;