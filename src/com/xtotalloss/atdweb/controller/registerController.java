package com.xtotalloss.atdweb.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class registerController extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		String realname = req.getParameter("username");
		String tel = req.getParameter("tel");
		String adres = req.getParameter("adres");
		String username = req.getParameter("realname");
		String password	= req.getParameter("password");
		String email = req.getParameter("email");
				
		if (("".equals(username) || "".equals(realname) || "".equals(password) || "".equals(email) || "".equals(adres) || "".equals(tel))) {
			req.setAttribute("msgReg", "Please fill in all forms.");
		} else {
			req.setAttribute("msgReg", "Account is succesfully created.");
			//GEBRUIKER TOEVOEGEN AAN ARRAYLIST
		}

		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);
	}
}