package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;

//@WebServlet("/LoginCon")	> service �� ��� ���ϴϱ� �����ص� �ȴ� // ��� �������̽�(�������̵�) ����� 
public class LoginCon implements ICommand {

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		//MemberDAO�� login �޼ҵ带 Ȱ���Ͽ�
//		// �α��� ���θ��ĳ天�ϰ� �α��ο� �����ߴٸ�
//		// session �� �α��ο� ������ ����� ��� �������� �����Ͻÿ� 
//
//		String email = request.getParameter("email");
//		String pw = request.getParameter("pw");
//
//		MemberDTO dto = new MemberDTO(email, pw);
//		MemberDAO dao = new MemberDAO();
//		
//		MemberDTO login_input= dao.login(dto);
//			//���� dto�� �´� ������ �°� id, pw, email, address �� �޾ƾ��Ͽ� dto���·� ��ȯ�� ����
//		
//		if(login_input!=null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("login_input", login_input);
//			
//			response.sendRedirect("main.jsp");
//		}
//		
//		//MemberDAO dao =new MemberDAO();
//		//dao.login();
//		
//		
//	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// MemberDAO�� login �޼ҵ带 Ȱ���Ͽ�
		// �α��� ���θ��ĳ天�ϰ� �α��ο� �����ߴٸ�
		// session �� �α��ο� ������ ����� ��� �������� �����Ͻÿ�

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		MemberDTO dto = new MemberDTO(email, pw);
		MemberDAO dao = new MemberDAO();

		MemberDTO login_input = dao.login(dto);
		// ���� dto�� �´� ������ �°� id, pw, email, address �� �޾ƾ��Ͽ� dto���·� ��ȯ�� ����

		if (login_input != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login_input", login_input);
//			response.sendRedirect("main.jsp");	
			// �������̵��ϸ鼭 �ּҰ�(����)�� ��ȯ�ϱ�
		}

		// MemberDAO dao =new MemberDAO();
		// dao.login();

		return "main.jsp";
	}

}
