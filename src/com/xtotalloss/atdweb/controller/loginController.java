package com.xtotalloss.atdweb.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginController extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		
		RequestDispatcher rd;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
				
		if (("".equals(username) || "".equals(password))) {
			rd = req.getRequestDispatcher("index.jsp");
			req.setAttribute("msgLog", "Please fill in all forms.");
		} else {
			rd = req.getRequestDispatcher("account.jsp");
			//SESSION OF COOKIE SETTEN
		}
		
		rd.forward(req, resp);
	}
}