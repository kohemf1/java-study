<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	CookieBox cBox = new CookieBox(request);
    
    	String reid = cBox.exists("reid") ? cBox.getValue("reid") : "" ;
    	String checked = cBox.exists("reid") ? "checked" : "" ;
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
</style>
<script>
</script>
</head>
<body>

	<div class="contents">
	
		<h2>Login</h2>
		<hr>
		<form action = "login.jsp" method="post">
			<tr>
				<th>ID</th>
				<th><input type="text" name="memberid" value=<%=reid %>></th>
			<tr>
			<tr>
				<th>PW</th>
				<th><input type="password" name="password"></th>
			<tr>
			<tr>
				<th></th>
				<th><input type="checkbox" name="reid" value="on" <%= checked %>>
				아이디 기억하기
				</th>
			<tr>
			<tr>
				<th></th>
				<th><input type="submit"></th>
			<tr>
				
		</table>
		
		</form>
		<table>

</body>
</html>