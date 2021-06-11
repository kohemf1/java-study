-- 2021.06.11

-- join

-- cross join
-- 스키마의 합 : 집합의 곱 연산과 같다

select *
from emp, dept
where emp.deptno = dept.deptno 
;

-- 이름이 SCOTT인 사원( = where)의 이름과 부서명 출력
-- 출력해야하는 컬럼을 가지는 테이블을 확인해보자.
-- 이름 : emp, 부서명 : dept
SELECT e.ename,d.dname, e.deptno
FROM EMP e,DEPT d
WHERE e.DEPTNO = d.DEPTNO --AND e.ENAME = 'SCOTT'
ORDER BY d.dname asc, e.ename asc
;

-- self join : 자기 자신을 조인 ( 참조 )
-- emp -> mgr 컬럼이 emp.mepno 참조
select e.empno, e.ename, e.mgr, m.ename
from emp e, emp m
where e.mgr = m.empno(+) -- (+) 아웃터조인  
order by e.job 
;




