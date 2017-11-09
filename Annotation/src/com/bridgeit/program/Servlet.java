package com.bridgeit.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("unused")
@WebServlet(value="/Servlet")

public class Servlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;  
	     @Override
	 	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			PrintWriter pw =resp.getWriter();
			resp.setContentType("text/html");
		    int  num=12;
	        int avg=5;
			req.getRequestDispatcher("index.jsp").include(req, resp);
			
		}
}
