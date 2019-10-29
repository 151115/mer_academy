package com.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.websocket.Session;

public class MessageDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@localhost:1521:xe"; 
			String db_id = "hr"; 
			String db_pw = "hr";
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {e.printStackTrace(); }
		catch (SQLException e) {e.printStackTrace();}

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

	
	public int save_msg(MessageDTO dto) {
		getConnection();
		int cnt=0; 
		String sql = "insert into web_message values(seq_num.nextval,?,?,?,sysdate)"; 
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getSend_name() );
			psmt.setString(2, dto.getReceive_email());
			psmt.setString(3, dto.getContent() );
			cnt = psmt.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }
		finally { close(); }
		
		return cnt;
	}
	
	public ArrayList<MessageDTO> select( String email ) {
		
		ArrayList<MessageDTO> list = new ArrayList<MessageDTO>();
		
		getConnection();

		String sql = "select * from web_message where receive_email= ?"; 
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String send_name = rs.getString(2);
				String receive_email = rs.getString(3);
				String content = rs.getString(4);
				String sendDate = rs.getString(5);
				MessageDTO sv_dto = new MessageDTO(num, send_name, receive_email , content ,sendDate);			
				list.add(sv_dto);
			}
			
		} catch (SQLException e) { e.printStackTrace(); }
		finally { close(); }
		
		return list;
	}

	public int deleteAll(String email) {

		getConnection();
		int cnt =0;
		
		String sql = "delete from web_message where receive_email= ?"; 
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, email);
			cnt = psmt.executeUpdate();
			
			
		} catch (SQLException e) { e.printStackTrace(); }
		finally { close(); }
		
		return cnt ;
	}

	public int delete(int num) {

		getConnection();
		
		int cnt =0;
		
		String sql = "delete from web_message where num= ?"; 
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			cnt = psmt.executeUpdate();
			
		} catch (SQLException e) { e.printStackTrace(); }
		finally { close(); }
		
		return cnt ;
		
	}
	
	
	
	
}
