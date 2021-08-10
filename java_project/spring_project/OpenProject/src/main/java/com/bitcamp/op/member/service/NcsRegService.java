package com.bitcamp.op.member.service;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.op.jdbc.ConnectionProvider;
import com.bitcamp.op.jdbc.JdbcUtil;
import com.bitcamp.op.member.dao.MemberDao;
import com.bitcamp.op.member.domain.Member;
import com.bitcamp.op.member.domain.NcsRegRequest;
import com.bitcamp.op.member.domain.RegInfo;

@Service
public class NcsRegService {

	@Autowired
	private MemberDao dao;
	
	final String UPLOADFILE = "/uploadfile";
	
	public int regService(
			NcsRegRequest regRequest,
			HttpServletRequest request
			) {
		
		int resultCnt = 0;
		Connection conn = null;
		File newFile = null;
		
		try {		
			// 경로
			String path = request.getSession().getServletContext().getRealPath(UPLOADFILE);
			// 저장폴더
			File newDir = new File(path);
			
			// 폴더 없을때 폴더 새로 만들기
			if(!newDir.exists()) {
				newDir.mkdir();
				System.out.println("저장 폴더 생성!!!!!!!!");
			}
			// 같은 이름의 파일 방지
			String nfn = regRequest.getMemberid()+System.currentTimeMillis();
			newFile = new File(newDir, nfn);
			
			//파일 저장
			if(regRequest.getPhoto() != null && !regRequest.getPhoto().isEmpty()) {
				regRequest.getPhoto().transferTo(newFile);	
			}
			
			conn = ConnectionProvider.getConnection();
			
			Member member = regRequest.toMember();
			member.setMemberphoto(nfn);
			
			resultCnt = dao.insertMember(conn, member);
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// db예외 발생하면 저장된파일 삭제
			if(newFile != null && newFile.exists()) {
				newFile.delete();
			}
			e.printStackTrace();
		} finally {
			JdbcUtil.close(conn);
		}
		
		return resultCnt;
	}
	
}
