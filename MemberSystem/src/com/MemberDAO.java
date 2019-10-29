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
//			System.out.println("JDBC Driver를 찾을 수 없습니다.");
//		} 
//		// 메소드로 빼서 삭제해도 됨 
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("SQL 문장이 잘못되었습니다.");
		} finally {
			close();
//			try {
//				if (psmt != null)
//					psmt.close();
//				if (conn != null)
//					conn.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//				System.out.println("DB가 올바르게 종료되지 않았습니다.");
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
		// ResultSet 에는 커서 개념이 있다
		// 커서를 옮기므로 로그인정보를 가져온다

		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String db_id = "hr";
//			String db_pw = "hr";
//			conn = DriverManager.getConnection(db_url, db_id, db_pw);	//db용이라 catch를 하나 더 잡아줘야함

			String sql = "select * from member_web where id  =? and pw =?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getId()); // sql 이랑 같은 지 비교
			psmt.setString(2, dto.getPw());
			rs = psmt.executeQuery(); // 변화일시 executeUpdate , 보기만 할때는 executeQuery 이용

			if (rs.next()) // boolean 이 참이라면 > 로그인 하였을 경우임 (커서가 한 칸 내려올 수 있었다면 )
			{
				System.out.println("로그인 성공! ");
				login_id = rs.getString(1);
				System.out.println("로그인 id  : " + login_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//		//sql은 안없애지만 이건 없애기 

		finally {
			close();
//				try {	// db에 관련된건 어쩌고하면서 예외처리해줘야함
//						// null인경우에서 하면 널포인트 입샙션이 일어남 
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
