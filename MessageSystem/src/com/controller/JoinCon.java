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
//		// 드라이버 로드하기 전에 자료파일을 넣어주면 좋다  (오라클 파일 라이브러리 넣어주기)
//		// == Class.forName("oracle.jdbc.driver.OracleDriver"); 하기 (드라이버 로드해주는 클레스)
//		
//
//		MemberDTO dto = new MemberDTO(email, pw, tel, address);
//		MemberDAO dao = new MemberDAO();	//객체생성
//
//		// 내가 만든 join
//		int join = dao.join(dto);
//		if (join>0) { response.sendRedirect("main.jsp"); } 
//		
////		//선생님이 만든 join
////		dao.join(dto);
//		
//		
//		
//	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("EUC-KR");	//없어도 ㄱㅊ?
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		
		// 드라이버 로드하기 전에 자료파일을 넣어주면 좋다  (오라클 파일 라이브러리 넣어주기)
		// == Class.forName("oracle.jdbc.driver.OracleDriver"); 하기 (드라이버 로드해주는 클레스)
		

		MemberDTO dto = new MemberDTO(email, pw, tel, address);
		MemberDAO dao = new MemberDAO();	//객체생성

		// 내가 만든 join
		int join = dao.join(dto);
		
		if (join>0) return "main.jsp";
		else return null;
		
	}

}
