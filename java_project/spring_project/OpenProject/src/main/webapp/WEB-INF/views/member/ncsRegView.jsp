<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 </title>
</head>
<body>

	<c:if test="${result eq 1}">
		<h1>회원가입 완료</h1> <hr>
		<button onclick="location.href= '<c:url value='/'/>'">홈으로</button>
	</c:if>
	<c:if test="${result eq 0}">
		<h1>회원가입 실패</h1> <hr>
		<button onclick="history.go(-1);"> 뒤로가기 </button>
	</c:if>
</body>
</html>