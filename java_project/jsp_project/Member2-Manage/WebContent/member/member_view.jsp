<%@page import="member.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<Member> list = (List<Member>)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td {
		text-align : center;
		padiing : 10px 10px;
	}
	
	button {
		margin : 10px;
	}
</style>
<script>
</script>
</head>
<body>
	
	<h1>회원 리스트</h1>
	<hr>
	
	<button onclick="location.href='insert_form.jsp';">회원 가입</button>
	
	<table border=1>
		<tr>
			<td>id</td>
			<td>pw</td>
			<td>이름</td>
			<td>등록일</td>
		</tr>
		<%
			if(list != null){
				for(int i=0; i<list.size(); i++){
					%>
			<tr>
				<td><%= list.get(i).getId() %></td>
				<td><%= list.get(i).getPw() %></td>
				<td><%= list.get(i).getName() %></td>
				<td><%= list.get(i).getRegdate() %></td>
			</tr>		
				<%
				}
			}
		%>
	</table>
	
</body>
</html>