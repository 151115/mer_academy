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
			// cnt 가 0 이면 실패로 실패창, 1 이상이면 성공으로 로그인 창으로 보내준다 
			// 배열로 묶어서 보낼 수 있음 > 자료형이 같아야함 > 직접 만듬 > DTO 

		if (cnt > 0) {
			response.sendRedirect("main.jsp");
		} else {
			response.sendRedirect("join.jsp");
		}

	}

}
