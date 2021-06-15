-- 20210615
-- DDL : 데이터 정의어

-- 테이블 생성 : CREATE TABLE
-- 테이블 수정 : ALTER TABLE
-- 테이블 삭제 : DROP TABLE

-- CREATE TABLE (
--          컬럼이름 타입(사이즈) 제약조건 정의,
--             .....
-- )

-- CREATE TABLE (
--          컬럼이름 타입(사이즈) ,
--             .....,
--             제약조건 정의, ....
-- )

-- 사원 테이블과 유사한 구조의
-- 사원번호, 사원이름, 급여 3개의 칼럼으로 구성된
-- emp01 테이블을 생성해 보자

create table emp01 (
    empno number(4), -- 사원번호
    ename varchar2(20), -- 사원이름
    sal number(6,2) -- 급여
);


-- 서브쿼리를 이용해서 기존 테이블의 구조를 복사하고
-- 해당 튜플도 복사 할수있다.
create table emp02
as
select * from emp
;

select * from emp02;
-- 제약조건은 복사하지 않아서 수정을 통해 직접 입력해줘야한다
create table emp03
as
select empno,ename,sal from emp;

select * from emp03;

create table emp04
as
select * from emp where deptno = 30
;
select * from emp04;

create table emp05
as
select * from emp where 1=2 -- 결과값이 false 이므로 데이터없이 구조만 복사 가능
;
select * from emp05; 

-- 테이블의 변경 : alter table
-- alter table {테이블 이름} add 
-- alter table {테이블 이름} modify
-- alter table {테이블 이름} drop

-- emp01 테이블에 job 컬럼을 추가해보자
alter table emp01 
add (job VARCHAR2(9))
;
desc emp01;

-- emp01 테이블에 job 컬럼의 사이즈를 수정  9 -> 30
alter table emp01 
MODIFY (job varchar2(130) not null)
;
desc emp01;

-- emp01 테이블의 job 컬럼을 삭제 해보자
alter table emp01
drop column job
;

-- 테이블 삭제
drop table emp06;
drop table emp02;


-- 새로운 테이블 생성
create table emp02
as
select * from emp
;
select * from emp02;

-- 모든 행을 삭제 truncate : 롤백이 안된다. 
TRUNCATE table emp02;

-- 테이블의 이름 변경 -> rename 현재이름 to 바꿀이름
rename emp01 to test;
desc emp01;

drop table emp02;


-- 컬럼 레벨에서 제약 사항 정의
create table emp02(
    empno number(4) constraint emp02_empno_pk primary key, -- not null unique,
    ename varchar2(20) constraint emp02_ename_nn not null,
    sal number(6,2) constraint emp02_sal_ck check (sal > 500 and sal < 5000),
    job varchar(20) default '미지정',
    deptno number constraint emp02_deptno_fk REFERENCES dept(deptno) -- 외래키 정의
)
;
insert into emp02 (empno, ename, sal, job, deptno)
    values(2000, 'SON', 4000,'MANAGER', 40);
insert into emp02 values(null, null,  'MABAGER', 10000); 
-- 모든데이터를 입력하면 생략가능

SELECT * FROM EMP02;

desc dept;

-- 테이블 레벨에서 제약 사항 정의
create table emp03(
    empno number(4),-- constraint emp02_empno_pk primary key, -- not null unique,
    ename varchar2(20) constraint emp03_ename_nn not null, -- not null 제약은 컬럼레벨에서만 가능
    sal number(6,2) constraint emp03_sal_ck check (sal > 500 and sal < 5000), 
    job varchar(20) ,--default '미지정',
    deptno number,-- constraint emp02_deptno_fk REFERENCES dept(deptno) -- 외래키 정의
    -----------------------------------------------------------------
    -- 제약 정의
    constraint emp03_empno_pk primary key (empno), -- pk 제약
    constraint emp03_deptno foreign key (deptno) references dept(deptno)
);
desc emp03;























