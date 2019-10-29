package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;

//@WebServlet("/UpdateCon")
public class UpdateCon  implements ICommand {

//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//		//클라이언트에게 반환 해 줄 타입 설정 
//		
//		response.setContentType("text/html; charset=euc-kr");
//		PrintWriter out = response.getWriter();
//		
//		request.setCharacterEncoding("EUC-KR");
//		HttpSession session = request.getSession();
//		MemberDTO preDto = (MemberDTO) session.getAttribute("login_input");
//		
//		String email= preDto.getEmail();
//		String pw = request.getParameter("pw");
//		String tel = request.getParameter("tel");
//		String address = request.getParameter("address");
//
//		
//		MemberDTO dto =new MemberDTO(email, pw, tel, address);
//		MemberDAO dao = new MemberDAO();
//		
//		int cnt = dao.update(dto);
//		if ( cnt > 0) { 
//			//수정 성공시 , 세션에 업데이트 된 dto 저장
//			session.setAttribute("login_input", dto);
//
//			out.print("<script>");
//			out.print("alert('회원정보수정 성공!');");
//			out.print("location.href='main.jsp' ;");
//			out.print("</script>");
////			response.sendRedirect("main.jsp"); 
//			
//		
//		}
//		else { response.sendRedirect("update.jsp"); }
//		
//	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");
		HttpSession session = request.getSession();
		MemberDTO preDto = (MemberDTO) session.getAttribute("login_input");
		
		String email= preDto.getEmail();
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");

		
		MemberDTO dto =new MemberDTO(email, pw, tel, address);
		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.update(dto);
		if ( cnt > 0) { 
			//수정 성공시 , 세션에 업데이트 된 dto 저장
//			session.setAttribute("login_input", dto);
//
//			out.print("<script>");
//			out.print("alert('회원정보수정 성공!');");
//			out.print("location.href='main.jsp' ;");
//			out.print("</script>");
			return "main.jsp";
			
		}
		else return "update.jsp"; 
		
	}

}
