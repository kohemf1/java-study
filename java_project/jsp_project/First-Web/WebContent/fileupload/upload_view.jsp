<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>upload_view</title>
<style>
</style>
<script>
</script>
</head>
<body>
	
	<h1>파일 업로드</h1>
	<h3>
		<c:if test="${title ne null}">
			Title : ${title}<br>
		</c:if>
		<c:if test="${photo ne null}">
			<img src="<c:url value = "/upload/${photo}"/>">
			
		</c:if>
	</h3>
	
</body>
</html>