<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
<p style="margin-top:-12px">
    <em class="link">
        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">
            혹시 주소 결과가 잘못 나오는 경우에는 여기에 제보해주세요.
        </a>
    </em>
</p>
<div id="map" style="width:100%;height:350px;"></div>
<input type="text" id="order_address" name="shipAddress" placeholder="주소" readonly>
<input type="button" id="btn_address" onclick="btn_execDaumPostcode()" value="우편번호 찾기">
<input type="text" id="order_postcode" placeholder="우편번호" readonly>
<input type="text" id="order_extraAddress" placeholder="참고항목" readonly>
<input type="text" id="order_detailAddress" placeholder="상세주소">
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=deb84fa7a7c544a30c3fec245b0889ea&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('서울특별시 서대문구 연세로 50', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">연세대</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
}); 



</script>

	<div class="btn_order_pay">
		<button type="button" id="btn_pay" onclick="requestPay()">결제</button>
	</div>
	
	
	
	
</body>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<!-- iamport.payment.js -->
<script type="text/javascript"
	src="https://cdn.iamport.kr/js/iamport.payment-1.1.8.js"></script>
</head>
<script>
	var IMP = window.IMP; 
	IMP.init("imp57300102"); 
	function requestPay() {			
			
		// IMP.request_pay(param, callback) 결제창 호출
		IMP.request_pay({ // param
			pg : 'html5_inicis', //ActiveX 결제창은 inicis를 사용
			pay_method : 'card', //card(신용카드), trans(실시간계좌이체), vbank(가상계좌), phone(휴대폰소액결제)
			merchant_uid : 123123,
			name : "asdasd",
			amount : 100,
			buyer_email : "",
			buyer_name :1,
			buyer_tel : 2,
			buyer_addr : 3,
			buyer_postcode : 4
		}, function(rsp) { // callback
			if (rsp.success) {
				// 결제 성공 시 로직
        		$.ajax({
				type : 'POST',
				url : "<c:url value='/game/order/${gamepage.gameIdx}'/>",
				data :$("#order_form").serialize(),
				
				success: function(returnData){   
						alert("성공")
						
					},
					error:function(request,status,error){   //데이터 주고받기가 실패했을 경우 실행할 결과
						//alert('실패');
						alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
						
					},
			   		 complete : function(){	
			   		 }
				
				
				});	
				alert("결제가 완료되었습니다.")
				location.href="<c:url value='/game/gamepage/${gamepage.gameIdx}'/>"
  			} else {
				alert("결제에 실패하였습니다. \n에러 내용: " + rsp.error_msg);
			}	
		});
		
	}  	
  	
	
	
	
  </script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    function btn_execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
                if(data.userSelectedType === 'R'){
                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraAddr !== ''){
                        extraAddr = ' (' + extraAddr + ')';
                    }
                    // 조합된 참고항목을 해당 필드에 넣는다.
                    document.getElementById("order_extraAddress").value = extraAddr;
                
                } else {
                    document.getElementById("order_extraAddress").value = '';
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('order_postcode').value = data.zonecode;
                document.getElementById("order_address").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("order_detailAddress").focus();
            }
        }).open();
    }
</script>
</html>