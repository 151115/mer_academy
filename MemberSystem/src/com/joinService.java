package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joinService")
public class joinService extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int cnt = 0;
		request.setCharacterEncoding("EUC-KR");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		

		MemberDTO dto = new MemberDTO(id, pw, name);
		MemberDAO dao = new MemberDAO();
		cnt = dao.join(dto);
			// cnt �� 0 �̸� ���з� ����â, 1 �̻��̸� �������� �α��� â���� �����ش� 
			// �迭�� ��� ���� �� ���� > �ڷ����� ���ƾ��� > ���� ���� > DTO 

		if (cnt > 0) {
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("join.jsp");
		}

	}

}
