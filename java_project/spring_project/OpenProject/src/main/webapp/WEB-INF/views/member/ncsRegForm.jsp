<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<script>
/*현재 url  */
document.writeln(location.href);
</script>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@ include file="/WEB-INF/views/frame/metaheader.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/frame/header.jsp" %>
<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
	
	<div id="content">
		<!-- <h1>content : login </h1> -->
		<!-- ncs -->
			<h2>회원가입</h2>		
		<hr>
		<form method="post" enctype="multipart/form-data">

		<table>
				<tr>
					<td>아이디3</td>
					<td>
						<input type="text" name="memberid" id="memberid">
					</td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="password" name="password"></td>
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="membername"></td>
				</tr>
				<tr>
					<td>사진</td>
					<td><input type="file" name="photo"></td>
				</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit">
						<input type="reset" >
					</td>
				</tr>
			</table>		
		</form>
	</div>
		
	
	
</body>
</html>