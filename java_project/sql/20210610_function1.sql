-- 2021.06.10
-- function : 단일행 함수, 집합(다중행) 함수
-- 단일행 함수 : 하나의 행이 포함하는 특정 컬럼의 값 하나를 처리하고 반환
-- 다중햄(집합) 함수 : 여러행의 특정 컬럼값들을 대상으로 연산하고 반환


-- 숫자 함수
select abs(10), abs(-10) 
from dual
;
--select * from dual;

select FLOOR(15.7) from dual;

select ROUND(15.198,2), ROUND(15.193,-1),round(15.193,-2)
from dual;

select TRUNC(15.79,1), trunc(15.79)
from dual;

select MOD(11,4)
from dual;

-- 사원들의 급여
select sal, mod(sal,2)
from emp
where mod(sal,2) = 1 
;



-- 문자 함수
-- concat(문자, 문자) -> '' ||''
select concat('abc','efg'), 'abc'||'efg'
from dual
;

-- substr : 문자열 추출
-- substr(문자열, 시작위치, 길이)
select substr('apple',1,3)
from dual
;

select substr('apple',-3)
from dual;

-- replace : 특정 문자열(패턴) 다른 문자열(패턴)으로 변경
select REPLACE('JACK and JUE','J','**') 
from dual
;

select sysdate
from dual;


-------------------------------------------------------
-- 2021.06.11
----------------------------------------------------

-- 형변환 함수 
-- 날짜 -> 문자, 
-- to_char(날짜 데이터, '패턴'), to_char(숫자, '패턴')
select sysdate, to_char(sysdate,'YYYY.MM.DD. HH24:MI:SS')
from dual;

select ename,hiredate,to_char(hiredate, 'YYYY.MM.DD')
from emp
ORDER BY HIREDATE
;

SELECT * FROM orders;

select orderid, orderdate, to_char(orderdate,'YYYY.MM.DD.')
from orders;

-- 숫자 -> 문자
select to_char(123456,'L0,000,000,000'), to_char(123456,'L9,999,999,999')
from dual;

select empno, ename, sal, to_char(sal*1100,'L9,999,999,999') as upsal
from emp
order by empno;



-- 문자 -> 숫자 
-- to_number(문자열, 패턴)
select to_number('1,000,000', '9,999,999'),
to_number('1,000,000', '9,999,999') + 100000
from dual
;


-- 문자 -> 날짜
-- to_date(문자열, 패턴)
select  TO_DATE('2012.05.17', 'YYYY.MM.DD'),
trunc((sysdate-TO_DATE('2012.05.17', 'YYYY.MM.DD'))/365)
from dual;

-- decode 함수 : 분기를 위해 사용 switch-case 유사
-- decode (컬러, = 조건1 값, 조건1이 참일때 사용할 값,
--                조건2 값, 조건2가 참일때 사용할 값,
--                ............)

-- emp 테이블에서 부서번호에 맞는 부서이름을 출력
select * 
from dept
;
-- 10 ACCOUNTING
-- 20 RESEARCH
-- 30 SALES
-- 40 OPERATIONS

select ename, deptno, 
       decode(deptno, 10 , 'ACCOUNTING',
                      20 , 'RESEARCH',
                      30 , 'SALES',
                      40 , 'OPERATIONS') as DNAME
from emp
ORDER BY DNAME
;

--8. 직급에 따라 급여를 인상하도록 하자. 
-- 직급이 'ANAlYST'인 사원은 5%, 'SALESMAN'인 사원은 10%, 
-- 'MANAGER'인 사원은 15%, 'CLERK'인 사원은 20%인 인상한다.

SELECT ename, sal,
       trunc( decode(job, 'ANALYST', sal*1.05,
                    'SALESMAN', sal*1.1,
                    'MANAGER', sal*1.15,
                    'CLERK', sal*1.2)) as upsal
FROM EMP;

-- case 함수도 분기할 때 사용
-- case when 조건식 then 참일때 값
select ename, deptno, 
        case when deptno = 10 then 'ACCOUNTING'
             when deptno = 20 then 'RESEARCH'
             when deptno = 30 then 'SALES'
             when deptno = 40 then 'OPERATION'
        END as DNAME
from emp
ORDER BY DNAME DESC;
