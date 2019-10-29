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

		} catch (ClassNotFoundException e) {	// class.format �� ����ȵ� ��� ����ó��
			e.printStackTrace();
		}
		catch (SQLException e) {	// String db_url ~ db_pw Ʋ����� ����ó��
			e.printStackTrace();
		}


	}
	
	// ���� ���� join
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
			psmt = conn.prepareStatement(sql); // sql �� ������ ��ȯ���� 
			psmt.setString(1, dto.getEmail() ); // SQLException e
			psmt.setString(2, dto.getPw() ); // SQLException e
			psmt.setString(3, dto.getTel() ); // SQLException e
			psmt.setString(4, dto.getAddress() ); // SQLException e
			cnt = psmt.executeUpdate();
				// ����Ʈ�϶�.execute ����
				// �μ�Ʈ�϶� ������Ʈ 

		}
		catch (SQLException e) { e.printStackTrace(); }
		finally { close(); }
		return cnt;
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

	public MemberDTO login(MemberDTO dto) {
		
		getConnection();
//		String login_email=null;
		MemberDTO set_dto =null;
		try {
			String sql = "select * from web_member where email =? and pw =?"; // SQLException e
			psmt = conn.prepareStatement(sql); // sql �� ������ ��ȯ���� 
			psmt.setString(1, dto.getEmail() ); // SQLException e
			psmt.setString(2, dto.getPw() ); // SQLException e
			
			rs =psmt.executeQuery();	//rs�� ǥ���·� ����
			
			if (rs.next() ) {
				System.out.println("�α��� ����! ");
				set_dto = new MemberDTO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4) );				
//				System.out.println("�α��� email  : " + dto.getEmail() );
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
	
	
	////������ join > �� joincon�� ���� 
	
	
}
