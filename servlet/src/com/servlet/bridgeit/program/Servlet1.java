package com.servlet.bridgeit.program;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  
			PrintWriter pw=resp.getWriter();
			String firstName=req.getParameter("fast");
			String lastName=req.getParameter("last");
		    String date=req.getParameter("date");
		    pw.println("<html><body>date "+date+"</body></html>");
		   
			/*Date date1=Date.valueOf(date);*/
			String gender=req.getParameter("gnd");
			String number=req.getParameter("cont");
			//Long num=Long.valueOf(number);
			String email=req.getParameter("userid");
			String password=req.getParameter("psd");
			String re_password=req.getParameter("pasd2");
			//pw.print("<html><body> hello</body></html>");
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conne=DriverManager.getConnection("jdbc:mysql://localhost/program1", "root", "101023");
				PreparedStatement pStatement=conne.prepareStatement("insert into program1.Detail values(?,?,?,?,?,?,?)");
				if(password.equals(re_password)) 
				{
					pStatement.setString(1, firstName);
					pStatement.setString(2, lastName);
					//Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
					SimpleDateFormat sdf1 = new SimpleDateFormat("dd/mm/yyyy");
					java.util.Date date1 = sdf1.parse(date);
					java.sql.Date sqlStartDate = new java.sql.Date(date1.getTime());  
					pStatement.setDate(3,  sqlStartDate);
					pStatement.setString(4, gender);
					Long num=Long.parseLong(number);
					pStatement.setLong(5, num);
					pStatement.setString(6, email);
					pStatement.setString(7, password);
					int i=pStatement.executeUpdate();
					if(i>0) 
					{
						//pw.print("<html><body>SuceesFullyStore</body></html>"); 
						RequestDispatcher rd=req.getRequestDispatcher("/Home.html");
						rd.include(req, resp);
					}
				}
				else 
				{
					pw.print("<html><body> Note Conformation passward </body></html>");
					RequestDispatcher rd=req.getRequestDispatcher("/Home.html");
					rd.include(req, resp);				}
		} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			pw.close();
		}
}
