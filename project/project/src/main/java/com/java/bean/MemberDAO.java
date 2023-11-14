package com.java.bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import java.io.UnsupportedEncodingException;
import java.sql.*;

public class MemberDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null; 
	
	private final static String USER_FIND = "select ID,passwd from members where ID=?;";
	private final static String USER_INSERT = "insert into members values(?,?)";
	private final static String USER_LIST = "select * from members;";
	public int loginProcess(MemberDTO mem){
		try {
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(USER_FIND);
			pstmt.setString(1,mem.getID());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString("ID").equals("admin")&& rs.getString("passwd").equals("root")) {
					return 100;
				}
				if(rs.getString("passwd").equals(mem.getPW())) return 1;
				else return 2;
			}
			return -1;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCutil.close(rs, pstmt, conn);
		}
		return -2;
	}
	public int insertProcess(CreateDTO cre){
		int cnt = 0;
		try {
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(USER_INSERT);
			pstmt.setString(1, cre.getCID());
			pstmt.setString(2, cre.getCPW());
			cnt = pstmt.executeUpdate();
			System.out.println(cnt);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(pstmt, conn);
		}
		return cnt;
	}
	public ArrayList<RegisterDTO> selectMemberList() throws SQLException{
		ArrayList<RegisterDTO> aList = new ArrayList<RegisterDTO>();
		try {
			conn = JDBCutil.getConnection();
			pstmt = conn.prepareStatement(USER_LIST);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				RegisterDTO rd = new RegisterDTO();
				rd.setMemberid(rs.getString("ID"));
				rd.setPassword(rs.getString("passwd"));
				aList.add(rd);
				System.out.println(rd.getMemberid());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(rs,  pstmt, conn);
		}
		return aList;
	}
}