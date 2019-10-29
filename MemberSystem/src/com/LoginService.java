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
		
		String login_id =null;	//�α��� ������ ���� ���� ������ 

		MemberDTO dto = new MemberDTO(id , pw);
		MemberDAO dao = new MemberDAO();
		
		login_id = dao.login(dto);
		
//		MemberDAO �� �Ű��� 
//		
//		Connection conn = null; 
//		PreparedStatement psmt = null;
//		ResultSet rs = null; 
//		
//			// ResultSet ���� Ŀ�� ������ �ִ� 
//			// Ŀ���� �ű�Ƿ� �α��������� �����´�
//		
//		
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			String db_url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String db_id = "hr";
//			String db_pw = "hr";
//				
//			conn = DriverManager.getConnection(db_url, db_id, db_pw);	//db���̶� catch�� �ϳ� �� ��������
//			
//			String sql ="select * from member_web where id  =? and pw =?";
//				
//			psmt = conn.prepareStatement(sql);	
//			psmt.setString(1, id);		//sql �̶� ���� �� �� 
//			psmt.setString(2, pw);
//			rs = psmt.executeQuery(); 	// ��ȭ�Ͻ� executeUpdate , ���⸸ �Ҷ��� executeQuery �̿� 
//				
//			if ( rs.next() )		//boolean �� ���̶�� > �α��� �Ͽ��� ����� (Ŀ���� �� ĭ ������ �� �־��ٸ� )
//			{ 
//				System.out.println("�α��� ����! "); 
//				login_id = rs.getString(1);
//				System.out.println("�α��� id  : "+login_id);
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
//			}
			if (login_id !=null) {
				response.sendRedirect("loginSuccess.jsp?id=" + login_id);
			}else {
				response.sendRedirect("login.jsp");
			}
			
//			//�����̷�Ʈ ���
//			Ŭ���̾�Ʈ�� ������ ��û
//			��û�� url�� ������
//			Ŭ���̾�Ʈ�� url�� �޾Ƽ� ������
//			
			
		}
		
		
		
		
	

}
