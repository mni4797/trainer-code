package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.models.Hero;
import com.fasterxml.jackson.databind.ObjectMapper;

public class HeroServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException
        {
			Hero staticHero = new Hero();
			staticHero.setHero_alias("Batman");
			staticHero.setHero_name("Bruce Wayne");
			resp.setContentType("application/json");
			resp.getWriter().write(new ObjectMapper().writeValueAsString(staticHero));
        }
}
