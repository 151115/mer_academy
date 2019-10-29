package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/LogoutCon")
public class LogoutCon implements ICommand {
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		HttpSession session = request.getSession();
//		session.removeAttribute("login_input");
//		response.sendRedirect("main.jsp");
//		//session Àº 
//	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("login_input");
		response.sendRedirect("main.jsp");
		return null;
	}

}
