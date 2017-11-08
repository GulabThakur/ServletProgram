package com.bridgeit.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
				@Override
				protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					String name=req.getParameter("name");
					String number=req.getParameter("num");
					PrintWriter pw =resp.getWriter();
					//create cookies
					Cookie cookie=new Cookie("unCookie", name);
					// add cookies 
					resp.addCookie(cookie);
					pw.print("<form action='servlet2'>");  
					pw.print("<input type='submit' value='go'>");  
					pw.print("</form>");  
					pw.close();
				}
}
