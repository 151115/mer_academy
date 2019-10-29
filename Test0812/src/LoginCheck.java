

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id ="smart";
		String pw ="1234";
		
		String login_id = request.getParameter("id");
		String login_pw = request.getParameter("pw");
		
		if (id.equals(login_id) && pw.equals(login_pw)) {

			Cookie cookie = new Cookie("id", id);

			response.addCookie(cookie);
			response.sendRedirect("main.jsp");
		}else {
			response.sendRedirect("loginForm.html");
			
		}
	}

}
