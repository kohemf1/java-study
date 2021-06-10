-- 2021.06.10

-- 특정 데이터 검색 : 행검색 -> 컬럼 선택

-- 10번 부서의 사원리스트를 출력
-- 10번 부서 -> where dept=10
select *
from emp
where deptno = 10 ;


-- 이름이 'scott'인 사원을 출력
SELECT *
FROM EMP
WHERE ename = 'SCOTT'
;

-- 날짜타입의 데이터 비교시에도 작은 따옴표를 이용해야한다!!
select *
from emp
where hiredate = '96/11/17'
;

-- 논리 연산자 : and, or ,not
-- 10번 부서의 관리자 (manager)를 찾아 출력
select *
from emp
where deptno=10 and job='MANAGER'
;

select *
from emp
;
select * from customer;
select * from book;

commit;