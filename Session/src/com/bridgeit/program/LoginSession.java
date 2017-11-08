package com.bridgeit.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginSession extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			PrintWriter pw =resp.getWriter();
			req.getRequestDispatcher("link.html").include(req, resp);
			String name=req.getParameter("name");
			String pass=req.getParameter("password");
			if(pass.equalsIgnoreCase("nikku"))
					{
						pw.print("Welcome "+name);
						HttpSession session=req.getSession();
						session.setAttribute("seName", name);
					}
			else 
			{
				pw.print("Sorry Your password are note match");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
			pw.close();
		}
}
