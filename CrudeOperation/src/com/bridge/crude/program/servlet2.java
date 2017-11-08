package com.bridge.crude.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridge.crude.dao.ConnectionDao;
import com.bridge.crude.model.Employee;

public class servlet2  extends HttpServlet{
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String id=req.getParameter("id");
			int id2=Integer.parseInt(id);
			Employee e=ConnectionDao.getEmployee(id2);
			int id3=e.getEmpId();
			String name=e.getEmpName();
			String email=e.getEmpEmail();
			PrintWriter pw= resp.getWriter();
			pw.print("<html><body> name :"+name+" id :"+id3+" Email :"+email+"</body></html>");
		}
}
