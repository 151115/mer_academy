package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;
import com.model.MessageDAO;
import com.model.MessageDTO;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	
	HashMap<String, ICommand> map;
	
	@Override	// init > ���ʷ� ����Ǵ� �޼��� ( ���񽺺��� ���� )
	public void init() throws ServletException {
		
		map=new HashMap<String, ICommand>();
		map.put("/Login.do", new LoginCon());
		map.put("/Join.do", new JoinCon());
		map.put("/MessageDeleteAll.do", new MessageDeleteAllCon());
		map.put("/MessageDelete.do", new MessageDeleteCon());
		map.put("/Logout.do", new LogoutCon());
		map.put("/Message.do", new MessageCon());
		map.put("/Update.do", new UpdateCon());

		super.init();
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// session
		HttpSession session = request.getSession();

		// out.print
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();

		// *.do
		String reqURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = reqURI.substring(contextPath.length());

		// ����
		request.setCharacterEncoding("EUC-KR");

		// ���� ����
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		String send_name = request.getParameter("send_name");
		String receive_email = request.getParameter("receive_email");
		String content = request.getParameter("content");

		// dto, dao ����
		MemberDTO member_dto ;
		MemberDAO member_dao = new MemberDAO();

		MessageDTO message_dto;
		MessageDAO message_dao = new MessageDAO();
		String next_page ="";
		
		ICommand prosess = map.get(command);
		
		next_page =prosess.execute(request, response);
		
		response.sendRedirect(next_page);
		
		
//////////////////////////////////////////////////////////////////////////////
		
		
		if (command.equals("/Login.do")) {
			LoginCon login = new LoginCon();
			next_page = login.execute(request, response);
//			response.sendRedirect(next_page);	
		}
		
		else if (command.equals("/Join.do")) {
			JoinCon join = new JoinCon();
			next_page = join.execute(request, response);
//			response.sendRedirect(next_page);	
		} 
		
		else if (command.equals("/Update.do")) {
			UpdateCon update = new UpdateCon();
			next_page = update.execute(request, response);
		} 
		
		else if (command.equals("/Message.do")) {

			MessageCon msg = new MessageCon();
			next_page =  msg.execute(request, response);
			
		} else if (command.equals("/Logout.do")) {
			session.removeAttribute("login_input");
			response.sendRedirect("main.jsp");
		}
		
		else if (command.equals("/MssageDeleteAll.do")) {

			MemberDTO dto = (MemberDTO) session.getAttribute("login_input");
			String email2 = dto.getEmail();
			int cnt = message_dao.deleteAll(email2);

			out.print("<script>");
			if (cnt > 0)
				out.print("alert('�޼�����ü�� �����Ͽ����ϴ�');");
			else
				out.print("alert('�޼��� ������  �����Ͽ����ϴ�');");
			out.print("location.href='main.jsp' ;");
			out.print("</script>");

		} else if (command.equals("/MessageDelete.do")) {

			int num = Integer.parseInt(request.getParameter("num"));

			int cnt = message_dao.delete(num);
			System.out.println(cnt);

			out.print("<script>");
			if (cnt > 0)
				out.print("alert('�ش� �޼����� �����Ǿ����ϴ�');");
			// �����̼����� �������� ���ϱ� sendRedirect�� �ʿ����
			else
				out.print("alert('�޼��� ������  �����Ͽ����ϴ�');");
			out.print("location.href='main.jsp' ;");
			out.print("</script>");

		}
		
//		response.sendRedirect(next_page);	
//		
//////////////////////////////////////////////////////////////////////////////
//		
//		if (command.equals("/Login.do")) {
//			member_dto = new MemberDTO(email, pw);
//
//			MemberDTO login_input = member_dao.login(member_dto);
//
//			System.out.println("�α��� ");
//			login_input = member_dao.login(member_dto);
//			if (login_input != null) {
//				session.setAttribute("login_input", login_input);
//				response.sendRedirect("main.jsp");
//			}
//		} else if (command.equals("/Join.do")) {
//			System.out.println("join");
//			member_dto = new MemberDTO(email, pw, tel, address);
//			int join = member_dao.join(member_dto);
//			if (join > 0) {
//				response.sendRedirect("main.jsp");
//			}
//
//		} else if (command.equals("/Message.do")) {
//
//			message_dto = new MessageDTO(send_name, receive_email, content);
//
//			int cnt = message_dao.save_msg(message_dto);
//			out.print("<script>");
//			if (cnt > 0)
//				out.print("alert('�޼����� ����Ǿ����ϴ�');");
//			else
//				out.print("alert('����');");
//			out.print("location.href='main.jsp' ;");
//			out.print("</script>");
//
//		} else if (command.equals("/Logout.do")) {
//			session.removeAttribute("login_input");
//			response.sendRedirect("main.jsp");
//		} else if (command.equals("/MssageDeleteAll.do")) {
//
//			MemberDTO dto = (MemberDTO) session.getAttribute("login_input");
//			String email2 = dto.getEmail();
//			int cnt = message_dao.deleteAll(email2);
//
//			out.print("<script>");
//			if (cnt > 0)
//				out.print("alert('�޼�����ü�� �����Ͽ����ϴ�');");
//			else
//				out.print("alert('�޼��� ������  �����Ͽ����ϴ�');");
//			out.print("location.href='main.jsp' ;");
//			out.print("</script>");
//
//		} else if (command.equals("/MessageDelete.do")) {
//
//			int num = Integer.parseInt(request.getParameter("num"));
//
//			int cnt = message_dao.delete(num);
//			System.out.println(cnt);
//
//			
//			  out.print("<script>"); 
//			  if (cnt >0) out.print("alert('�ش� �޼����� �����Ǿ����ϴ�');");
//			  //�����̼����� �������� ���ϱ� sendRedirect�� �ʿ���� 
//			  else
//				  out.print("alert('�޼��� ������  �����Ͽ����ϴ�');");
//			  out.print("location.href='main.jsp' ;"); out.print("</script>");
//			 
//		}else if (command.equals("/Update.do")) {
//
//		MemberDTO preDto = (MemberDTO) session.getAttribute("login_input");
//		
//		email= preDto.getEmail();
//		pw = request.getParameter("pw");
//		tel = request.getParameter("tel");
//		address = request.getParameter("address");
//		
//		member_dto = new MemberDTO(email, pw, tel, address);
//		
//		int cnt = member_dao.update(member_dto);
//		out.print("<script>");
//		if ( cnt > 0) { 
//			//���� ������ , ���ǿ� ������Ʈ �� dto ����
//			session.setAttribute("login_input", member_dto);
//			out.print("alert('ȸ���������� ����!');");
//			out.print("location.href='main.jsp' ;");
////			response.sendRedirect("main.jsp"); 
//			
//		}
//		else { 
//
//			out.print("alert('�ٽ�');");
//			out.print("location.href='update.jsp' ;");
//			}
//
//		out.print("</script>");
//	} 

	}

}
