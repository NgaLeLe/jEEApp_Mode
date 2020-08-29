package com.control.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.logique.ConvertirArgent;

@WebServlet("/Convertir")
public class UserConvertir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UserConvertir() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
	//	String type = request.getParameter("optTypeArgent");
		String total = session.getAttribute("montant").toString();
		String res = (String)session.getAttribute("result");
		String error = (String) session.getAttribute("error");
		int montant = 0;
		if (total != null) {
			montant = Integer.valueOf(total);
		}
		if (res != null) {
			res = null;
		} 
		if (error == null) error = "";
		System.out.println("doGetConvertir : result = " + session.getAttribute("result"));
		System.out.println("error = " + error);
		System.out.println("DoGET, montant = " + montant);
//		if (!error.contentEquals("2") && !error.contentEquals("1"))
//			error = "";
//		if (type == null)
//			type = "";
		if (montant == 0)
			montant = 0;
//		session.setAttribute("optTypeArgent", type);
		session.setAttribute("montant", montant);
		session.setAttribute("result", res);
		session.setAttribute("error", error);
		request.getRequestDispatcher("/vue/reussiConnect.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		String type = request.getParameter("optTypeArgent");
		String toType = "";
		String total = request.getParameter("montant");
		int montant = 0;
		if (total != null) {
			montant = Integer.valueOf(total);
		}
//		 = Integer.valueOf(request.getParameter("montant"));
		double tmpChange = 0;
		String result = "";
		String error = "";
		ConvertirArgent change = new ConvertirArgent();
		if (type != null) {
			if (montant <= 100000) {
				if (type.contentEquals("EURO")) {
					tmpChange = change.convertToUSD(montant);
					toType = "$";
				} else {
					tmpChange = change.convertToEURO(montant);
					toType = "€";
				}
				 result = tmpChange + " " + toType;
			} else {
				error = "2";
			}
		} else {
			error = "1";
		}
		session.setAttribute("result", result );
		session.setAttribute("montant", montant);
		session.setAttribute("error", error);
		System.out.println("Dopost Convertir");
		doGet(request, response);
	}

}
