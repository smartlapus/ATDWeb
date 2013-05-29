package com.xtotalloss.atdweb.controller;

import com.xtotalloss.atdweb.listeners.MyServletContextListener;
import com.xtotalloss.atdweb.model.*;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KlusAanpassen extends HttpServlet {
	private static final long serialVersionUID = 6787392421160231316L;
	private Bedrijf ATD = MyServletContextListener.ATD;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd;

	}
}
