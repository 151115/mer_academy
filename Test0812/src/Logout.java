

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie[] cookie = request.getCookies();
		
		
		for (int i=0 ; i< cookie.length ; i++) {
			cookie[i].setMaxAge(1);
			response.addCookie(cookie[i]);
		}
		
		response.sendRedirect("loginForm.html");
		
	}

}
