package com.servlet.bridgeit.program;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet extends  HttpServlet{
				@Override
				protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					PrintWriter pw=resp.getWriter();
					String email=req.getParameter("email");
					String password=req.getParameter("psd");
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/program1", "root", "101023");
						PreparedStatement preparedStatement=connection.prepareStatement("select * from program1.Detail where emailId = ?");
						preparedStatement.setString(1, email);
						preparedStatement.executeQuery();
						ResultSet rs=preparedStatement.getResultSet();
						while(rs.next())
						{
							String email1=rs.getString(6);
							String pass=rs.getString(7);
							String name=rs.getString(1);
							if(email.equalsIgnoreCase(email1) && password.equalsIgnoreCase(pass)) 
							{
								pw.print("<html><body> Welcome :"+name+"</body></html>");
							}
						}
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
}
