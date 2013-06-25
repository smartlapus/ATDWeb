package com.xtotalloss.atdweb.controller;

import com.xtotalloss.atdweb.model.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class klantenOverzicht extends HttpServlet {

	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = null;
		
		System.out.println("### klantenOverzicht.java -- klantenOverzicht.do executed");
		
	
		
		rd = req.getRequestDispatcher("klanten.jsp");
		rd.forward(req, resp);
		
		
	}
}
