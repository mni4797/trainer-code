package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.SuperVillain;

public class DirectServlet extends HttpServlet{
	// Method inherited and overriden from HttpServlet abstract class
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	        {
				System.out.println("Direct get");
				resp.setContentType("text/html");
				resp.getWriter().write("<html><body><h1>The Servlet is directly talking to the client</h1></body></html>");
	        }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException{
		System.out.println("In direct post!");
		// if we wanna send a supervillain as part of the http response, we need to package it
		resp.setContentType("application/json");
		// JSON - Javascript object notation
		// why send JSON? integrates well with JS, lightweight, keeps object structure well
		
		SuperVillain superVillain = new SuperVillain("Lex Luthor", "Genius", 2_000_000_000);
		//class we'll be using to transform our objects into JSON
		ObjectMapper objectMapper = new ObjectMapper();
		
		resp.getWriter().write(objectMapper.writeValueAsString(superVillain));
	}
}
