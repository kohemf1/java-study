<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>myblog</title>
    
    <!-- http://localhost:8080/First-Web/blog/css/210702myblog.css -->
    
    <link rel="stylesheet" href="/First-Web/blog/css/210702myblog.css">
</head>
<body>

    <div id="main_wrap">

        <!-- header 시작-->
        <header>
          <%@ include file="include/header.jsp" %>
        </header>
        <!--header 끝-->

        <!--navigation 시작-->
       		<%@ include file="include/nav.jsp" %>
        <!--navigation 끝-->

        <!--컨텐츠 영역 시작-->
        <div id="content_wrap">
            <section>
                <article class="border_bottom_a margin_bottom_20">
                    <h1 class="title">SSG닷컴, 올해 첫 구매 고객에 무료배송·1만원 할인쿠폰</h1>
                    <p class="date">2021.07.02</p>
                    <img class="post_img" src="../images/ssg.jpg">
                    <p class="postcontent">신세계그룹 온라인몰 SSG닷컴이 올해 첫 구매 고객을 대상으로 7월 한 달간 쓸 수 있는 ‘무료배송 쿠폰’과 ‘1만원 할인쿠폰’을 증정한다고 2일 밝혔다.

                        신규 가입고객은 물론 올해 구매내역이 없는 장기 미사용 고객도 혜택을 받을 수 있다. 오픈마켓을 제외한 모든 상품 구매에 사용할 수 있는 무료배송쿠폰 3장과 1만원 할인쿠폰 1장 등 총 4장의 쿠폰을 지급한다.
                        
                        SSG닷컴은 최근 야구단 SSG랜더스와 함께하는 스포츠 마케팅을 비롯해 W컨셉, 이베이코리아 인수 등으로 대외 노출 빈도가 증가하면서 사이트 방문자 수도 급격히 늘고 있는 추세라고 설명했다.
                        
                        김진설 SSG닷컴 마케팅담당은 “매월 다양한 소비자 혜택을 선보이며 시장 점유율 확대에 박차를 가하겠다”고 말했다</p>
                </article>

                <article class="border_bottom_a margin_bottom_20">
                    <h1 class="title">SSG닷컴, 올해 첫 구매 고객에 무료배송·1만원 할인쿠폰</h1>
                    <p class="date">2021.07.02</p>
                    <img class="post_img" src="../images/ssg.jpg">
                    <p class="postcontent">신세계그룹 온라인몰 SSG닷컴이 올해 첫 구매 고객을 대상으로 7월 한 달간 쓸 수 있는 ‘무료배송 쿠폰’과 ‘1만원 할인쿠폰’을 증정한다고 2일 밝혔다.

                        신규 가입고객은 물론 올해 구매내역이 없는 장기 미사용 고객도 혜택을 받을 수 있다. 오픈마켓을 제외한 모든 상품 구매에 사용할 수 있는 무료배송쿠폰 3장과 1만원 할인쿠폰 1장 등 총 4장의 쿠폰을 지급한다.
                        
                        SSG닷컴은 최근 야구단 SSG랜더스와 함께하는 스포츠 마케팅을 비롯해 W컨셉, 이베이코리아 인수 등으로 대외 노출 빈도가 증가하면서 사이트 방문자 수도 급격히 늘고 있는 추세라고 설명했다.
                        
                        김진설 SSG닷컴 마케팅담당은 “매월 다양한 소비자 혜택을 선보이며 시장 점유율 확대에 박차를 가하겠다”고 말했다</p>
                </article>
            </section>
          <%@ include file="include/aside.jsp" %>
        </div>
        <!--컨텐츠 영역 끝-->
        <!--footer 시작-->
       <%@ include file="include/footer.jsp" %>
        <!--footer 끝-->
    </div>
    
</body>
</html>