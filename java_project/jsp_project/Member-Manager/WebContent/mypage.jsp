<%@page import="domain.LoginInfo"%>
<%@page import="domain.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%--
	LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");	
	
	if(loginInfo == null){
		--%>
	<c:if test="${loginInfo eq null }">	
<script>
	alert('로그인이 필요한 페이지입니다. \n 로그인 후 사용해주세요!!');
	location.href = '<%= request.getContextPath()%>/loginForm.jsp';
</script>
	</c:if>				
		<%--
		
	} else{

--%>    
<c:if test="${loginInfo ne null }">
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인 정보</title>
<link rel="stylesheet" href="<%= request.getContextPath()%>/css/default.css"> 
<style>
</style>
<script>
</script>
</head>
<body>

<%@ include file="/WEB-INF/frame/header.jsp" %>

<%@ include file="/WEB-INF/frame/nav.jsp" %>

	<div class="contents">
	
		<h2>My page</h2>
		<hr>
		<h3>
			${loginInfo}
			<%--= loginInfo --%>
		</h3>
	
	</div>


</body>
</html>
</c:if>
<%--}--%>