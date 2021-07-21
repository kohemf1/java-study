<%@page import="member.domain.Member"%>
<%@page import="jdbc.util.ConnectionProvider"%>
<%@page import="member.dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	
	request.setCharacterEncoding("utf-8");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");

	int resultCnt = 0;
	
	try{
	
		Connection conn = null;
		MemberDao dao = MemberDao.getInstance();
		
		conn = ConnectionProvider.getConnection();
		resultCnt = dao.insertMember(conn, new Member(id,pw,name));
	
	} catch(Exception e){
		e.printStackTrace();
	}
	if(resultCnt>0){
		%>
		<script>
			alert('등록완료');
			location.href = "member_list.jsp"
		</script>
		<%
		
	} else {
		%>
		<script>
			alert('오류가 발생했습니다 \n입력페이지로 이동합니다');
			location.href = "insert_form.jsp"
		</script>
		<%
	}
	
%>