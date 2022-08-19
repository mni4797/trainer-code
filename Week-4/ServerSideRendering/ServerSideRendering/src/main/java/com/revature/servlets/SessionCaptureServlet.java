package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.SuperVillain;

public class SessionCaptureServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
        {
			// 1. grab the session from the request
		HttpSession session = req.getSession();
		// 2. get the superVillain from the session
		SuperVillain superVillain = (SuperVillain) session.getAttribute("the-villain");
		// 3. After gettting the villain let's print out their info
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		if(superVillain != null) {
			out.println("We have captured the villain!");
			out.println("<h1>Villain name: "+superVillain.getName() + "</h1></br>");
			out.println("<b>Superpower: "+superVillain.getSuperPower() + "</b></br>");
			out.println("<i>Bounty: "+superVillain.getBounty() + "php</i></br>");
		} else {
			out.println("<i>No villains in session</i>");
		}
		out.println("</body></html>");
        }
	@Override 
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	        {
				HttpSession session = req.getSession();
				// clearing the session
				session.invalidate();
	        }
}
