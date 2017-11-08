package com.bridgeit.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ProfileServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			PrintWriter pw=resp.getWriter();
			req.getRequestDispatcher("link.html").include(req, resp);
			HttpSession session=req.getSession(false);
			if(session!=null)
			{
				String name=(String) session.getAttribute("seName");
				pw.print("Welcome :"+name);
			}
			else 
			{
				pw.println("Please Login ");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		}
}
