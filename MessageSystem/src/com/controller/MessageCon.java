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
//		// 1 ������ ��� , �޴� �̺���, ������ �������ÿ�.
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
////		// 2 �� ������ db�� �����Ͻÿ�.
//		MessageDTO dto = new MessageDTO(send_name , receive_email ,content);
//		MessageDAO dao = new MessageDAO();
//		
//		int cnt = dao.save_msg(dto);
//		
//		out.print("<script>");
//		if (cnt > 0)
//			out.print("alert('�޼����� ����Ǿ����ϴ�');");
//		else
//			out.print("alert('����');");
//		out.print("location.href='main.jsp' ;");
//		out.print("</script>");
//	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();

		request.setCharacterEncoding("EUC-KR");
		// 1 ������ ��� , �޴� �̺���, ������ �������ÿ�.

		String send_name = request.getParameter("send_name");
		String receive_email = request.getParameter("receive_email");
		String content = request.getParameter("content");

//		
//		HttpSession session = request.getSession();
//
//		session.setAttribute("send_name", send_name);
//		session.setAttribute("recetive_email", receive_email);
//		// 2 �� ������ db�� �����Ͻÿ�.
		MessageDTO dto = new MessageDTO(send_name, receive_email, content);
		MessageDAO dao = new MessageDAO();

		dao.save_msg(dto);

		return "main.jsp";

	}

}
