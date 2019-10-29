package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MessageDAO;
import com.model.MessageDTO;

//@WebServlet("/MessageCon")
public class MessageCon implements ICommand {
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		response.setContentType("text/html; charset=euc-kr");
//		PrintWriter out = response.getWriter();
//		
//		request.setCharacterEncoding("EUC-KR");
//		// 1 보내는 사람 , 받는 이베일, 내용을 가져오시오.
//		
//		String send_name = request.getParameter("send_name");
//		String receive_email = request.getParameter("receive_email");
//		String content = request.getParameter("content");
//
////		
////		HttpSession session = request.getSession();
////
////		session.setAttribute("send_name", send_name);
////		session.setAttribute("recetive_email", receive_email);
////		// 2 위 정보를 db에 저장하시오.
//		MessageDTO dto = new MessageDTO(send_name , receive_email ,content);
//		MessageDAO dao = new MessageDAO();
//		
//		int cnt = dao.save_msg(dto);
//		
//		out.print("<script>");
//		if (cnt > 0)
//			out.print("alert('메세지가 저장되었습니다');");
//		else
//			out.print("alert('실패');");
//		out.print("location.href='main.jsp' ;");
//		out.print("</script>");
//	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("EUC-KR");
		// 1 보내는 사람 , 받는 이베일, 내용을 가져오시오.

		String send_name = request.getParameter("send_name");
		String receive_email = request.getParameter("receive_email");
		String content = request.getParameter("content");

//		
//		HttpSession session = request.getSession();
//
//		session.setAttribute("send_name", send_name);
//		session.setAttribute("recetive_email", receive_email);
//		// 2 위 정보를 db에 저장하시오.
		MessageDTO dto = new MessageDTO(send_name, receive_email, content);
		MessageDAO dao = new MessageDAO();

		dao.save_msg(dto);

		return "main.jsp";

	}

}
