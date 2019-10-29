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
//			out.print("alert('해당 메세지가 삭제되었습니다');"); //로케이션으로 메인으로 가니까 sendRedirect가 필요없다
//		else
//			out.print("alert('메세지 삭제가  실패하였습니다');");
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
