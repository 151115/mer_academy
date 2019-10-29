package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDTO;
import com.model.MessageDAO;

//@WebServlet("/MessageDeleteCon")
public class MessageDeleteCon implements ICommand {
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		response.setContentType("text/html; charset=euc-kr");
//		PrintWriter out = response.getWriter();	
//		request.setCharacterEncoding("EUC-KR");
//		
//		
//		int num = Integer.parseInt( request.getParameter("num") );
//		
//		MessageDAO dao = new MessageDAO();
//		
//		int cnt = dao.delete(num);
//		System.out.println(cnt);
//		
//		out.print("<script>");
//		if (cnt >0)
//			out.print("alert('�ش� �޼����� �����Ǿ����ϴ�');"); //�����̼����� �������� ���ϱ� sendRedirect�� �ʿ����
//		else
//			out.print("alert('�޼��� ������  �����Ͽ����ϴ�');");
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
		
		
		int num = Integer.parseInt( request.getParameter("num") );
		
		MessageDAO dao = new MessageDAO();
		
		dao.delete(num);
		
		return "main.jsp";
	}
}
