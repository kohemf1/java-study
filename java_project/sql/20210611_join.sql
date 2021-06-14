-- 2021.06.11

-- join : 스키마의 합

-- cross join
-- 스키마의 합 : 집합의 곱 연산과 같다

select *
from emp, dept
where emp.deptno = dept.deptno 
;

-- ansi cross join
select * from orders;
select * from customer;
select * from book;


select o.orderid, c.name, b.bookname
from orders o, customer c, book b
where o.custid = c.custid and o.bookid = b.bookid
order by orderid
;

-- ansi -> inner join
-- 오라클 equi join
select *
from emp, dept
where emp.deptno = dept.deptno 
;

select * 
from emp e inner join dept d
on e.deptno = d.deptno
;

SELECT e.ename,d.dname, e.deptno
FROM EMP e,DEPT d
WHERE e.DEPTNO = d.DEPTNO --AND e.ENAME = 'SCOTT'
       AND e.ename='SCOTT'
ORDER BY d.dname asc, e.ename asc
;

select *
from emp e inner join dept d
on e.deptno = d.deptno
where e.ename = 'SCOTT'
;

-- 비교하는 컬럼의 이름이 같을때
-- on 절을 생략하고 -> using을 이용하면 조건식을 간략하게 처리

select *
from emp e inner join dept d
--on e.deptno = d.deptno
using (deptno)
where e.ename = 'SCOTT'
;

-- NATURAL JOIN
select * 
from emp NATURAL JOIN dept
;

-- 이름이 SCOTT인 사원( = where)의 이름과 부서명 출력
-- 출력해야하는 컬럼을 가지는 테이블을 확인해보자.
-- 이름 : emp, 부서명 : dept
SELECT e.ename,d.dname, e.deptno
FROM EMP e,DEPT d
WHERE e.DEPTNO = d.DEPTNO --AND e.ENAME = 'SCOTT'
       AND e.ename='SCOTT'
ORDER BY d.dname asc, e.ename asc
;


-- self join : 자기 자신을 조인 ( 참조 )
-- emp -> mgr 컬럼이 emp.mepno 참조
select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno(+) -- (+) 아웃터조인  
order by e.job 
;

-- outer join
select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno(+) -- 표현하고자 하는 컬럼이 있는 테이블의 반대쪽,
                        -- null값을 가지는 위치에 (+)해준다
order by e.job 
;

-- [left | right | full] outer jin
select e.ename, e.mgr, m.ename as "관리자"
from emp m right outer join emp e
on e.mgr = m.empno
;





 -- non equi join
 -- 동등 비교가 아닌 크다 작다와 같은 비교로
 -- 조인의 조건을 작성
 
select * from salgrade;

select e.ename, e.sal, s.grade, s.losal, s.hisal
from emp e, salgrade s
--where e.sal >= s.losal and e.sal <= s.hisal
where sal between s.losal and s.hisal
order by e.ename;


-- 회원별 구매 내역 출력
select c.name, count(o.orderid) as"구매횟수", avg(saleprice)
from orders o , customer c
where o.custid(+) = c.custid
group by c.name
order by c.name
;