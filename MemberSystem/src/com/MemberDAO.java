package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;

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

	private void getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String db_url = "jdbc:oracle:thin:@localhost:1521:xe"; // SQLException e
			String db_id = "hr"; // SQLException e
			String db_pw = "hr"; // SQLException e
			conn = DriverManager.getConnection(db_url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int join(MemberDTO dto) {
		getConnection();
		int cnt = 0;
//
//		Connection conn = null;
//		PreparedStatement psmt = null;

		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver"); // ClassNotFoundException e
//			String db_url = "jdbc:oracle:thin:@localhost:1521:xe"; // SQLException e
//			String db_id = "hr"; // SQLException e
//			String db_pw = "hr"; // SQLException e
//			conn = DriverManager.getConnection(db_url, db_id, db_pw);

			String sql = "insert into member_web values(?,?,?)"; // SQLException e
			psmt = conn.prepareStatement(sql); // SQLException e
			psmt.setString(1, dto.getId()); // SQLException e
			psmt.setString(2, dto.getPw()); // SQLException e
			psmt.setString(3, dto.getName()); // SQLException e
			cnt = psmt.executeUpdate();
		}
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//			System.out.println("JDBC Driver�� ã�� �� �����ϴ�.");
//		} 
//		// �޼ҵ�� ���� �����ص� �� 
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL ������ �߸��Ǿ����ϴ�.");
		} finally {
			close();
//			try {
//				if (psmt != null)
//					psmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println("DB�� �ùٸ��� ������� �ʾҽ��ϴ�.");
//			}
		}

		return cnt;
	}

	public String login(MemberDTO dto) {

		getConnection();
		String login_id = null;

//		
//		Connection conn = null; 
//		PreparedStatement psmt = null;
//		ResultSet rs = null; 
//		
		// ResultSet ���� Ŀ�� ������ �ִ�
		// Ŀ���� �ű�Ƿ� �α��������� �����´�

		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String db_id = "hr";
//			String db_pw = "hr";
//			conn = DriverManager.getConnection(db_url, db_id, db_pw);	//db���̶� catch�� �ϳ� �� ��������

			String sql = "select * from member_web where id  =? and pw =?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId()); // sql �̶� ���� �� ��
			psmt.setString(2, dto.getPw());
			rs = psmt.executeQuery(); // ��ȭ�Ͻ� executeUpdate , ���⸸ �Ҷ��� executeQuery �̿�

			if (rs.next()) // boolean �� ���̶�� > �α��� �Ͽ��� ����� (Ŀ���� �� ĭ ������ �� �־��ٸ� )
			{
				System.out.println("�α��� ����! ");
				login_id = rs.getString(1);
				System.out.println("�α��� id  : " + login_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		//sql�� �Ⱦ������� �̰� ���ֱ� 

		finally {
			close();
//				try {	// db�� ���õȰ� ��¼���ϸ鼭 ����ó���������
//						// null�ΰ�쿡�� �ϸ� ������Ʈ �Ի����� �Ͼ 
//					if(rs != null) 
//						rs.close();
//					if (psmt != null)
//						psmt.close();
//					if (conn != null)
//						conn.close();
//				} catch (SQLException e) {
//
//					e.printStackTrace();
//				}
		}

		return login_id;
	}

}
