package com.cos.apple.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.jsp.jstl.sql.Result;

import com.cos.apple.db.DBConn;

public class MemberDao {
	
	
	private Connection conn;
	private PreparedStatement pstmt;
	private Result rs;
	
	public int 회원가입(String username, String password, String email) {
		try {
			String sql = "INSERT INTO member(id, username, password, email, createDate) VALUES(member_seq.nextval, ?, ?, ?, sysdate)";
			conn = DBConn.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			pstmt.setString(3, email);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
}