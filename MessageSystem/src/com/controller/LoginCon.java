package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.MemberDAO;
import com.model.MemberDTO;

//@WebServlet("/LoginCon")	> service 를 사용 안하니까 삭제해도 된다 // 대신 인터페이스(오버라이딩) 사용함 
public class LoginCon implements ICommand {

//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		//MemberDAO의 login 메소드를 활용하여
//		// 로그인 여부를파녑ㄹ하고 로그인에 성공했다면
//		// session 에 로그인에 성공한 사람의 모든 정보를ㅈ ㅓ장하시오 
//
//		String email = request.getParameter("email");
//		String pw = request.getParameter("pw");
//
//		MemberDTO dto = new MemberDTO(email, pw);
//		MemberDAO dao = new MemberDAO();
//		
//		MemberDTO login_input= dao.login(dto);
//			//현재 dto에 맞는 정보에 맞게 id, pw, email, address 를 받아야하여 dto형태로 반환을 받음
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

		// MemberDAO의 login 메소드를 활용하여
		// 로그인 여부를파녑ㄹ하고 로그인에 성공했다면
		// session 에 로그인에 성공한 사람의 모든 정보를ㅈ ㅓ장하시오

		String email = request.getParameter("email");
		String pw = request.getParameter("pw");

		MemberDTO dto = new MemberDTO(email, pw);
		MemberDAO dao = new MemberDAO();

		MemberDTO login_input = dao.login(dto);
		// 현재 dto에 맞는 정보에 맞게 id, pw, email, address 를 받아야하여 dto형태로 반환을 받음

		if (login_input != null) {
			HttpSession session = request.getSession();
			session.setAttribute("login_input", login_input);
//			response.sendRedirect("main.jsp");	
			// 오버라이딩하면서 주소값(메인)을 반환하기
		}

		// MemberDAO dao =new MemberDAO();
		// dao.login();

		return "main.jsp";
	}

}
