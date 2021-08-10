//package com.bitcamp.op.member.service;
//
//import java.sql.Connection;
//import java.sql.SQLException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.bitcamp.op.jdbc.ConnectionProvider;
//import com.bitcamp.op.member.dao.MemberDao;
//import com.bitcamp.op.member.domain.RegInfo;
//
//@Service
//public class RegService {
//
//	@Autowired
//	MemberDao dao;
//	
//	public int regService(RegInfo info) {
//		
//	int resultCnt = 0;
//	
//	Connection conn = null;
//	
//	try {
//		conn = ConnectionProvider.getConnection();
//		
//		resultCnt = dao.insertMember(conn, info);
//		
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//
//	return resultCnt;
//	}
//	
//}
