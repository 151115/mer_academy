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
		// ��ü�� ���� ��쿡�� �ݾ��ְ� , ������ ��� ���� �ݾ�����ϹǷ� ������ ��ü�� �ݾ��ش�.
		try { // db�� ���õȰ� ��¼���ϸ鼭 ����ó���������
			// null�ΰ�쿡�� �ϸ� ������Ʈ �Ի����� �Ͼ
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
