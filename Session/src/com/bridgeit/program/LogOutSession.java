package com.bridgeit.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutSession  extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			resp.setContentType("text/html");
			//req.getRequestDispatcher("link.html").include(req, resp);
			PrintWriter pw =resp.getWriter();
			HttpSession session=req.getSession();
			session.invalidate();
			pw.print("You are logout sucessfully");
			pw.close();
		}
}
