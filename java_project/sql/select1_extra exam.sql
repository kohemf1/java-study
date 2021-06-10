-- 2021.06.10

select *
from book;


--(1) 도서번호가1인도서의이름
select bookname
from book
where bookid = 1
;

--(2) 가격이20,000원이상인도서의이름
select bookname
from book
where price >= 20000
;
select *
from customer;

--(3) 모든고객의이름, 주소
select name, address
from customer
;

select *
from orders;
-- (4) 2014년7월4일~7월7일사이에주문받은도서의주문번호
select bookid
from orders
where orderdate between '14/07/04' and '14/07/07'
;

--(5) 2014년7월4일~7월7일사이에주문받은도서를제외한도서의주문번호
select bookid
from orders
where orderdate not between '14/07/04' and '14/07/07'
;
--(6) 성이‘김’씨인고객의이름과주소
select name,address
from customer
where name like '김%'
;
--(7) 성이‘김’씨이고이름이‘아’로끝나는고객의이름과주소
select name, address
from customer
where name like '김%아'
;