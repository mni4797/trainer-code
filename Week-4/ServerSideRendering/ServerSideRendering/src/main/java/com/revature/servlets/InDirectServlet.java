package com.revature.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InDirectServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
        {
			// send redirect
			resp.sendRedirect("/ServerSideRendering/direct");
			// when we redirect, we send an HTTPResponse that tells the client to redirect to a certain
			// page/place
			// we send a 302
			// different url 
        }
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
        {
		// forward request
			RequestDispatcher redis = req.getRequestDispatcher("/direct");
			redis.forward(req, resp);
			// when forwarding a request, we are passing the buck internally and we don't inform the client
			// from the client's perspective, this servlet served their request 
			// same url
        }
}
