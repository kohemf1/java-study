<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("userName", request.getParameter("id"));

	//                    /First-Web/member1/mypage/mypage.jsp
	response.sendRedirect(request.getContextPath()+"/member1/mypage/mypage.jsp");
%>