<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<!-- PUBLIC "-//W3C//DTD HTML5 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello jsp</title>
<style>
</style>
<script>
</script>
</head>
<body>
	<%--
		//String name = "SON";
		
	--%>
	안녕하세요<%--= name --%>
	<%= request.getContextPath() %>
</body>
</html>