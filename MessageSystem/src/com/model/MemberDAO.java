package com.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@localhost:1521:xe"; // SQLException e
			String db_id = "hr"; // SQLException e
			String db_pw = "hr"; // SQLException e
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {	// class.format 가 연결안될 경우 예외처리
			e.printStackTrace();
		}
		catch (SQLException e) {	// String db_url ~ db_pw 틀릴경우 예외처리
			e.printStackTrace();
		}


	}
	
	// 내가 만든 join
	public int join(MemberDTO dto) {

		int cnt=0;
		getConnection();
		
		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String db_url = "jdbc:oracle:thin:@localhost:1521:xe"; // SQLException e
//			String db_id = "hr"; // SQLException e
//			String db_pw = "hr"; // SQLException e
//
//			conn = DriverManager.getConnection(db_url, db_id, db_pw);

			String sql = "insert into web_member values(?,?,?,?)"; // SQLException e
			psmt = conn.prepareStatement(sql); // sql 을 보내서 반환받음 
			psmt.setString(1, dto.getEmail() ); // SQLException e
			psmt.setString(2, dto.getPw() ); // SQLException e
			psmt.setString(3, dto.getTel() ); // SQLException e
			psmt.setString(4, dto.getAddress() ); // SQLException e
			cnt = psmt.executeUpdate();
				// 샐랙트일땐.execute 쿼리
				// 인설트일땐 업데이트 

		}
		catch (SQLException e) { e.printStackTrace(); }
		finally { close(); }
		return cnt;
	}
	
	
	private void close() {
		// 객체가 있을 경우에만 닫아주고 , 열었던 모든 것을 닫아줘야하므로 열었던 전체를 닫아준다.

		try { // db에 관련된건 어쩌고하면서 예외처리해줘야함
			// null인경우에서 하면 널포인트 입샙션이 일어남
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public MemberDTO login(MemberDTO dto) {
		
		getConnection();
//		String login_email=null;
		MemberDTO set_dto =null;
		try {
			String sql = "select * from web_member where email =? and pw =?"; // SQLException e
			psmt = conn.prepareStatement(sql); // sql 을 보내서 반환받음 
			psmt.setString(1, dto.getEmail() ); // SQLException e
			psmt.setString(2, dto.getPw() ); // SQLException e
			
			rs =psmt.executeQuery();	//rs는 표형태로 존재
			
			if (rs.next() ) {
				System.out.println("로그인 성공! ");
				set_dto = new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4) );				
//				System.out.println("로그인 email  : " + dto.getEmail() );
			}
		}
		catch (SQLException e) { e.printStackTrace(); }
		finally { close(); }
		
		return set_dto;
		
	}

	public int update(MemberDTO dto) {

		getConnection();
		int cnt=0;
		
		String sql = "update web_member set pw =?, tel =?, address=? where email= ? ";		
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPw() ); 
			psmt.setString(2, dto.getTel() ); 
			psmt.setString(3, dto.getAddress() ); 
			psmt.setString(4, dto.getEmail() ); 
			
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) { e.printStackTrace(); }
		finally { close(); }
		
		return cnt;
	}
	
	
	////선생님 join > 은 joincon에 존재 
	
	
}
