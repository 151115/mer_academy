package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.MemberDAO;
import com.model.MemberDTO;

//@WebServlet("/JoinCon")
public class JoinCon implements ICommand {
	
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		request.setCharacterEncoding("EUC-KR");
//		
//		String email = request.getParameter("email");
//		String pw = request.getParameter("pw");
//		String tel = request.getParameter("tel");
//		String address = request.getParameter("address");
//		
//		// ����̹� �ε��ϱ� ���� �ڷ������� �־��ָ� ����  (����Ŭ ���� ���̺귯�� �־��ֱ�)
//		// == Class.forName("oracle.jdbc.driver.OracleDriver"); �ϱ� (����̹� �ε����ִ� Ŭ����)
//		
//
//		MemberDTO dto = new MemberDTO(email, pw, tel, address);
//		MemberDAO dao = new MemberDAO();	//��ü����
//
//		// ���� ���� join
//		int join = dao.join(dto);
//		if (join>0) { response.sendRedirect("main.jsp"); } 
//		
////		//�������� ���� join
////		dao.join(dto);
//		
//		
//		
//	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");	//��� ����?
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		// ����̹� �ε��ϱ� ���� �ڷ������� �־��ָ� ����  (����Ŭ ���� ���̺귯�� �־��ֱ�)
		// == Class.forName("oracle.jdbc.driver.OracleDriver"); �ϱ� (����̹� �ε����ִ� Ŭ����)
		

		MemberDTO dto = new MemberDTO(email, pw, tel, address);
		MemberDAO dao = new MemberDAO();	//��ü����

		// ���� ���� join
		int join = dao.join(dto);
		
		if (join>0) return "main.jsp";
		else return null;
		
	}

}
