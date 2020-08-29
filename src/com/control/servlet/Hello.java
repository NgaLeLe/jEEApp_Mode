package com.control.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Hello
 */
@WebServlet("/index")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Hello() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//request.getRequestDispatcher("/vue/login.jsp").forward(request, response);
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession(true);
		if (nom==null) nom ="";
		if (email==null) email = "";
		if (password==null) password = "";
		session.setAttribute("nom", nom);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		this.getServletContext().getRequestDispatcher("/vue/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nom = request.getParameter("nom");
		String email = request.getParameter("email");
		String idEmail = email.substring(0, email.indexOf('@'));
		String password = request.getParameter("password");
		System.out.println(nom + " -- " + idEmail + " -- " + password );
		HttpSession session = request.getSession(true);
		if (nom != null && email.toLowerCase().endsWith("@yahoo.com") && password.contentEquals("666666")) {
			session.setAttribute("isConnect", true);
			session.setAttribute("nom", nom);
			session.setAttribute("email", email);
			session.setAttribute("password", password);
			request.getRequestDispatcher("/vue/reussiConnect.jsp").forward(request, response);
		} else {
			session.setAttribute("isConnect", false);
			doGet(request, response);
		}
	}

}
