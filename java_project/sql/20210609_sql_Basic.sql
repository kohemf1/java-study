-- 2021.06.09 
-- SQL Basic
-- 계정 HR이 보유(권한)한 테이블 객체 리스트
select * from tab;

-- 테이블의 정보 검색 : 컬럼의 이름 , null 유무 , 타입과 사이즈
desc dept;
desc emp;

-- 데이터 조회를 위한 명령 : Select
-- Select {컬럼명,...,*} from 테이블 이름;
select * from emp;

-- 필요한 컬럼을 출력
-- select 컬럼명 , 컬럼명 from 테이블 이름;
-- 사원번호와 사원이름 출력
select empno, ename, sal, deptno from emp;


-- select 컬럼의 산술연산이 가능 : 컬럼과 숫자의 연산 , 컬럼과 컬럼의 산술연산도 가능
-- 사원이름 , 월급여, 연봉계산 결과값(sal*12)
select  ename, sal, sal*12 as ysal  
from emp;
-- 데이터베이스에서 null값은 아직 정해지지않은값.
select sal, comm, sal*comm , sal*12, sal/10, sal-100, sal+1000
from emp;

select * from emp;

-- 사원의 이름, 직급, 급여 , 커미션, 연봉(급여*12), 연봉(급여*12+커미션)
select ename, job, sal, comm, sal*12 as ysal1, sal*12+comm as ysal2
from emp;

-- 개선 : null값을 0으로 치환해서 연산
-- nvl(컬럼 이름, 기본값) : 컬럼의 값이 null일때 기본값으로 치환
select ename, job, sal, nvl(comm,0), 
        sal*12 ysal1, sal*12+nvl(comm,0) as ysal2
from emp;


-- 컬럼과 문자열을 붙이는 연산 || 
-- sql에서 문자열 표현은 -> ' 작은 따움표 이용
select ename || ' is a ' || job
from emp;

-- 결과 리스트에서 중복된 값을 제거 : distinct
select deptno
from emp;

select distinct deptno
from emp;

select * from dept;

select DISTINCT deptno, job
from emp
order by deptno; -- 정렬 : 행의 정렬 

select *
from emp;

-- 특정 데이터를 검색하기위해서는
-- select ~ from 구문에 where절을 이용
-- where 뒤에는 조건식이 정의 -> where 컬럼명 비교연산자 값
-- where sal >= 3000 
-- 사원이름 , 사원번호 , 급여
select ename, empno, sal
from emp
where sal >= 3000;

commit;