package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.models.SuperVillain;

public class SessionServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
        {
			SuperVillain superVillain = new SuperVillain("Megamind", "Supergenius", 1);
			
			//Capture the HTTP session from the request object
			
			HttpSession session = req.getSession();
			
			// note about sessions, they store stuff in a key-value pair
			// The value of superVillain can be accessed via the key "the-villain"
			session.setAttribute("the-villain", superVillain);
			
			resp.getWriter().write("Megamind is on the loose");
        } 
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
	        {
				//Unpacking form elements sent via request
				String name = req.getParameter("myname");
				String superpower = req.getParameter("mysuperpower");
				int bounty = Integer.valueOf(req.getParameter("mybounty"));
				
				SuperVillain superVillain = new SuperVillain(name, superpower, bounty);
				HttpSession session = req.getSession();
				session.setAttribute("the-villain", superVillain);
				
				resp.getWriter().write("The CUSTOM villain " +name+ " is on the loose...");
	        }
	    

}
