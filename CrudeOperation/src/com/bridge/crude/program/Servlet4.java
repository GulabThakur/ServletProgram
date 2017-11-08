package com.bridge.crude.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridge.crude.dao.ConnectionDao;
import com.bridge.crude.model.Employee;

public class Servlet4 extends HttpServlet {
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				PrintWriter pw=resp.getWriter();
				String id=req.getParameter("id");
				String name=req.getParameter("name");
				String email=req.getParameter("email");
				int id2=Integer.parseInt(id);
				Employee emp=new Employee();
				emp.setEmpId(id2);
				emp.setEmpName(name);
				emp.setEmpEmail(email);
				int status=ConnectionDao.update(emp,id2);
				if(status>0) 
				{
					pw.print("<html><body>Data is update <body></html>");
				}
				
			}
}
