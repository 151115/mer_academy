package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDTO;
import com.model.MessageDAO;

//@WebServlet("/MessageDeleteAllCon")
public class MessageDeleteAllCon implements ICommand  {
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.setContentType("text/html; charset=euc-kr");
//		PrintWriter out = response.getWriter();	
//		request.setCharacterEncoding("EUC-KR");
//		
//		MessageDAO dao = new MessageDAO();
//		HttpSession session = request.getSession();
//		MemberDTO dto = (MemberDTO) session.getAttribute("login_input");
//		
//		String email =dto.getEmail();
//		
//		int cnt = dao.deleteAll(email);
//
//		out.print("<script>");
//		if (cnt >0) out.print("alert('�޼�����ü�� �����Ͽ����ϴ�');");
//		else out.print("alert('�޼��� ������  �����Ͽ����ϴ�');");
//		out.print("location.href='main.jsp' ;");
//		out.print("</script>");
//		
//	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();	
		request.setCharacterEncoding("EUC-KR");
		
		MessageDAO dao = new MessageDAO();
		HttpSession session = request.getSession();
		MemberDTO dto = (MemberDTO) session.getAttribute("login_input");
		
		String email =dto.getEmail();
		
		dao.deleteAll(email);
		
		return "main.jsp";
	}

}
