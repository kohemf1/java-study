-- 20210616
-- DML - phoneInfo

-- phoneinfo_basic 의 select, update, delete,insert 하는 sql
select * from phoneInfo_basic ;

insert into phoneInfo_basic (IDX, fr_name, fr_phonenumber,fr_email,fr_address)
    values (111111, 'son', '000-1111-1111', 'son@google.com', 'LONDON');
insert into phoneInfo_basic (IDX, fr_name, fr_phonenumber,fr_email,fr_address)
    values (222222, 'PARK', '000-1111-2222', 'park@naver.com', 'SEOUL');
insert into phoneInfo_basic (IDX, fr_name, fr_phonenumber,fr_email,fr_address)
    values (333333, 'BOOM', '000-2222-2222', 'boom@naver.com', 'SEOUL');
insert into phoneInfo_basic (IDX, fr_name, fr_phonenumber,fr_email,fr_address)
    values (444444, 'LEE', '000-1234-1234', 'lee@naver.com', 'MADRID');

UPDATE phoneInfo_basic
SET FR_NAME = 'SON'
where idx = 111111
;

delete from phoneInfo_basic where idx = 222222;

--2.phoneinfo_univ 의 select,update,delete,insert 하는 sql
desc phoneinfo_univ;
select * from phoneinfo_univ; -- 111111 444444
insert into phoneinfo_univ values (111111, '경영학', 2, 111111);
insert into phoneinfo_univ (idx, fr_u_major, fr_ref) 
        values (111111, '전기', 111111);
insert into phoneinfo_univ (idx, fr_u_major, fr_ref) 
        values (444444, '전기', 444444);

update phoneinfo_univ
set fr_u_year = 4
where idx = 444444
;

delete from phoneinfo_univ 
where idx = 111111 and fr_u_major = '전기'
;
delete from phoneinfo_univ 
where idx = 111111 
;
delete from phoneinfo_basic
where idx = 111111;

select * from phoneinfo_basic pb , phoneinfo_univ pu
where pu.fr_ref = pb.idx
;
--3.phoneinfo_com  의 select,update,delete,insert 하는 sql
select * from phoneinfo_com;

insert into phoneinfo_com (idx, fr_ref)
VALUES (333333,333333 );

update phoneinfo_com
set fr_c_company = 'INTEL'
where idx = 333333
;

delete from phoneinfo_com
where idx = 333333 and fr_c_company = 'INTEL'
;
delete from phoneinfo_basic
where idx = 333333
;