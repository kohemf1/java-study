
--43. 사원 번호가 7788인 사원과 담당 업무가 같은 사원을 표시(사원 이름과 담당업무)하시오.
select ename, job
from emp
where job in ( select job from emp where empno = 7788)
;

--44. 사원번호가 7499인 사원보다 급여가 많은 사원을 표시하시오. 사원이름과 감당 업무
select ename,job
from emp
where sal > (select sal from emp where empno=7499)
;

--45. 최소급여를 받는 사원의 이름, 담당업무 및 급여를 표시하시오. (그룹함수 사용)
select ename,job,sal
from emp 
where sal = (select min(sal) from emp)
;

--46. 평균급여가 가장 적은 직급의 직급 이름과 직급의 평균을 구하시오.
select job, avg(sal)
from emp 
group by job
having avg(sal) = (select min(avg(sal)) from emp group by job)
;

--47. 각 부서의 최소 급여를 받는 사원의 이름, 급여, 부서번호를 표시하시오.
select ename, sal, deptno
from emp
where sal in (select min(sal) from emp group by deptno)
;

--​48. 담당업무가 ANALYST 인 사원보다 급여가 적으면서 
-- 업무가 ANALYST가 아닌 사원들을 표시(사원번호, 이름, 담당 업무, 급여)하시오.
select empno,ename,job,sal
from emp
where sal < all ( select sal from emp where job = 'ANALYST') 
        and job !='ANALYST'
;

--49. 부하직원이 없는 사원의 이름을 표시하시오.
SELECT ename
from emp 
where not empno in(select distinct mgr from emp where mgr is not null) 
;
--50. 부하직원이 있는 사원의 이름을 표시하시오.
SELECT ENAME
FROM EMP
WHERE EMPNO IN ( SELECT DISTINCT MGR FROM EMP WHERE MGR IS NOT NULL)
;

--51. BLAKE와 동일한 부서에 속한 
-- 사원의 이름과 입사일을 표시하는 질의를 작성하시오. ( 단 BLAKE는 제외 )
select ename,hiredate
from emp
where deptno in ( select deptno from emp where ename = 'BLAKE') 
    AND ENAME != 'BLAKE'
;

--52. 급여가 평균 급여보다 많은 사원들의 
-- 사원 번호와 이름을 표시하되 결과를 급여에 대해서 오름차순으로 정렬하시오.
select empno, ename
from emp
where sal > (select avg(sal) from emp)
order by sal asc
;

--​53. 이름에 K가 포함된 사원과 같은 부서에서 일하는 사원의 사원 번호와 이름을 표시하시오.
select empno , ename
from emp
where DEPTNO in(select deptno from emp where ename like '%K%')
;
-- 54. 부서위치가 DALLAS인 사원의 이름과 부서번호 및 담당업무를 표시하시오.
select ename,deptno,job
from emp
where deptno in ( select deptno from dept where loc = 'DALLAS')
;
--55. KING에게 보고하는 사원의 이름과 급여를 표시하시오.
SELECT ENAME,SAL
from emp
where empno in ( select empno from emp 
        where mgr = (select empno from emp where ename = 'KING'))
;
--​56. RESEARCH 부서의 사원에 대한 부서번호, 사원이름 및 담당 업무를 표시하시오.
select deptno, ename, job
from emp
where deptno = ( select deptno from dept where dname='RESEARCH')
;
--57. 평균 월급보다 많은 급여를 받고 
--이름에 M이 포함된 사원과 같은 부서에서 근무하는 사원의 
--사원 번호, 이름, 급여를 표시하시오.
SELECT empno,ename,sal
from emp
where sal > all (select avg(Sal) from emp) and 
    deptno in (select deptno from emp where ename like '%M%') 
;

-- 58. 평균급여가 가장 적은 업무를 찾으시오.
select job, avg(sal)
from emp
group by job
having avg(sal) in(select min(avg(sal)) from emp group by job )
;
--59.담당업무가 MANAGER 인 사원이 소속된 부서와 동일한 부서의 사원을 표시하시오.
select ename
from emp
where deptno in ( select deptno from emp where job = 'MANAGER')
;

-- (5) 박지성이구매한도서의출판사수
SELECT COUNT(PUBLISHER)
from book
where bookid in ( select bookid from customer c,orders o
where c.custid = o.custid and c.name = '박지성')
;

-- (6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select b.bookname , price, abs(b.price -o.saleprice) as pricegap 
from book b, orders o
where b.bookid = o.bookid and o.bookid in 
(select bookid from orders o1 , customer c 
where o1.custid = c.custid and c.name = '박지성')
;
-- (7) 박지성이구매하지않은도서의이름
select bookname
from book
where not bookid in ( select bookid from orders o, customer c
    where o.custid = c.custid and c.name = '박지성')
;

--(8) 주문하지않은고객의이름(부속질의사용)
select name
from customer 
where not name in ( select name from orders o ,customer c
    where o.custid = c.custid)
;

--(9) 주문금액의총액과주문의평균금액
select sum(saleprice) , avg(saleprice)
from orders
;
--​(10) 고객의이름과고객별구매액
select name, sum(saleprice)
from customer c, orders o
where c.custid = o.custid
group by c.name
;
--(11) 고객의이름과고객이구매한도서목록
select name , bookname
from customer c, book b, orders o
where c.custid = o.custid and o.bookid = b.bookid
order by name 
;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
select *
from book b, orders o
where o.bookid = b.bookid and
abs(b.price - o.saleprice) = (select max(abs(b1.price - o1.saleprice))
from book b1, orders o1 where b1.bookid = o1.bookid )
;
