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
	    

}
