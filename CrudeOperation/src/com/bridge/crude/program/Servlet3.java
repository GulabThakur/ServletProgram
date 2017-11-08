package com.bridge.crude.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridge.crude.dao.ConnectionDao;

public class Servlet3 extends HttpServlet {
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				    PrintWriter pw=resp.getWriter();	
				    String id=req.getParameter("id");
					int numid=Integer.parseInt(id);
					pw.print("<html><body> value "+numid+"</body></html>");
					int status=ConnectionDao.delete(numid);
					if(status>0) {
					pw.print("<html><body> Data sucessfully dalete</body></html>");
					}
					else 
					{
						pw.print("<html><body> No record Avilable</body></html>");
					}
					
			}
}
