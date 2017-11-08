package com.bridge.crude.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridge.crude.dao.ConnectionDao;
import com.bridge.crude.model.Employee;

public class InsertData extends HttpServlet{
			@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String id=req.getParameter("id");
				String name=req.getParameter("name");
				String email=req.getParameter("email");
				PrintWriter pw=resp.getWriter();
				Employee emp=new Employee();
				emp.setEmpId(Integer.parseInt(id));
				emp.setEmpName(name);
				emp.setEmpEmail(email);
				int status=ConnectionDao.save(emp);
				System.out.println(status);
					pw.print("<html><body>Data stored</body></html>");
					RequestDispatcher rd=req.getRequestDispatcher("/display.html");
					rd.include(req, resp);
				
				
			}
}
