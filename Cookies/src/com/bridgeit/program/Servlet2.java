package com.bridgeit.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2  extends HttpServlet{
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            PrintWriter pw = resp.getWriter();  
		    Cookie ck[]=req.getCookies();  
		    pw.print("Hello "+ck[0].getValue());  
		    Cookie ck1=new Cookie("unCookie","");//deleting value of cookie  
		    ck1.setMaxAge(0);//changing the maximum age to 0 seconds  
		    resp.addCookie(ck1);//adding cookie in the response  
		    pw.close();  

	 }

}
