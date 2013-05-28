package com.xtotalloss.atdweb.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class logoutController extends HttpServlet {
	private static final long serialVersionUID = 368426482586939199L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		req.getSession().invalidate();
		rd.forward(req, resp);
	}
}