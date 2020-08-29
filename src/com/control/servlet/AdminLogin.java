package com.control.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/Admin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AdminLogin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		if (email==null) email = "";
		if (password==null) password = "";
		this.getServletContext().getRequestDispatcher("/vue/loginAdmin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		System.out.println(email + "---" + password);
		HttpSession session = request.getSession(true);
		if (email.contentEquals("admin@yahoo.com") && password.contentEquals("admin")) {
			session.setAttribute("isConnected", true);
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			request.getRequestDispatcher("/vue/adminEspace.jsp").forward(request, response);
		}
		else {
			session.setAttribute("error", "1");
			session.setAttribute("isConnected", false);
			System.out.println(request.getContextPath());
			response.sendRedirect(request.getContextPath()+"/Admin?error=1");

	}

}
}
