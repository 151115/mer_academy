package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginService")
public class LoginService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		String login_id =null;	//로그인 성공시 값을 담을 변수들 

		MemberDTO dto = new MemberDTO(id , pw);
		MemberDAO dao = new MemberDAO();
		
		login_id = dao.login(dto);
		
//		MemberDAO 로 옮겨줌 
//		
//		Connection conn = null; 
//		PreparedStatement psmt = null;
//		ResultSet rs = null; 
//		
//			// ResultSet 에는 커서 개념이 있다 
//			// 커서를 옮기므로 로그인정보를 가져온다
//		
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String db_id = "hr";
//			String db_pw = "hr";
//				
//			conn = DriverManager.getConnection(db_url, db_id, db_pw);	//db용이라 catch를 하나 더 잡아줘야함
//			
//			String sql ="select * from member_web where id  =? and pw =?";
//				
//			psmt = conn.prepareStatement(sql);	
//			psmt.setString(1, id);		//sql 이랑 같은 지 비교 
//			psmt.setString(2, pw);
//			rs = psmt.executeQuery(); 	// 변화일시 executeUpdate , 보기만 할때는 executeQuery 이용 
//				
//			if ( rs.next() )		//boolean 이 참이라면 > 로그인 하였을 경우임 (커서가 한 칸 내려올 수 있었다면 )
//			{ 
//				System.out.println("로그인 성공! "); 
//				login_id = rs.getString(1);
//				System.out.println("로그인 id  : "+login_id);
//			}
//			} catch (SQLException e) {
//
//
//				
//				e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} finally {
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
//			}
			if (login_id !=null) {
				response.sendRedirect("loginSuccess.jsp?id=" + login_id);
			}else {
				response.sendRedirect("login.jsp");
			}
			
//			//리다이렉트 방식
//			클라이언트가 서버로 요청
//			요청시 url을 돌려줌
//			클라이언트가 url를 받아서 접속함
//			
			
		}
		
		
		
		
	

}
