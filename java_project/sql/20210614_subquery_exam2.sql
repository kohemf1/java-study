--20210614

--(5) 박지성이구매한도서의출판사수
select count(publisher)
from  book 
where bookid in (select bookid from customer c, orders o
        where c.name = '박지성' and c.custid = o.custid)
;

select *
from book
;
select *
from orders
;

--(6) 박지성이구매한도서의이름, 가격, 정가와판매가격의차이
select bookname,price, b.price - o.saleprice as pricegap
from book b , orders o, customer c
where o.bookid = b.bookid and o.custid = c.custid and c.name = '박지성';

--(7) 박지성이구매하지않은도서의이름
select bookname
from book b 
where not bookid in(select bookid from orders o , customer c
    where c.custid = o.custid and c.name = '박지성')
;


--(8) 주문하지않은고객의이름(부속질의사용)
select name
from customer
where  not custid in (select custid from orders)
;
--(9) 주문금액의총액과주문의평균금액
select sum(saleprice), avg(saleprice)
from orders
;

--(10) 고객의이름과고객별구매액
select name ,sum(saleprice)
from orders o, customer c
where o.custid = c.custid
group by name
;

--(11) 고객의이름과고객이구매한도서목록
select name, bookname
from customer c, orders o, book b
where o.bookid = b.bookid and o.custid = c.custid
order by name
;
select *
from book
;

--(12) 도서의가격(Book 테이블)과판매가격(Orders 테이블)의차이가가장많은주문
select *
from  orders o , book b
where b.bookid = o.bookid and abs(o.saleprice-b.price) = 
    (select max(abs(o1.saleprice-b1.price)) from book b1, orders o1 
    where b1.bookid = o1.bookid) 
;

--(13) 도서의판매액평균보다자신의구매액평균이더높은고객의이름
select name
from orders o ,customer c
where o.custid = c.custid
group by name
having avg(o.saleprice) > (select avg(saleprice) from orders)
;
--(1) 박지성이 구매한 도서의 출판사와 같은 출판사에서 도서를 구매한 고객의 이름
select name
from book b, orders o, customer c
where b.bookid = o.bookid and c.custid = o.custid and 
    b.publisher in ( select publisher from book 
    where bookid in ( select bookid from orders o1, customer c1
    where o1.custid = c1.custid and c1.name = '박지성')) and c.name != '박지성'
;
--(2) 두 개 이상의 서로 다른 출판사에서 도서를 구매한 고객의 이름
select name
from book b, orders o, customer c
where o.custid = c.custid and b.bookid = o.bookid 
group by c.name
having count(distinct b.publisher) >= 2
;