package com.bridgeit.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bridgeit.program.Mailer;
public class MailServlet extends HttpServlet {

	    @Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					resp.setContentType("text/html");
					PrintWriter pw=resp.getWriter();
					String to=req.getParameter("to");
					String sub=req.getParameter("subject");
					String text=req.getParameter("msg");
					pw.print("To "+to+"");
					pw.println("Sub "+sub+"");
					pw.println("text "+text+"");
					Mailer.send(to, sub, text);
					pw.print("mail Sucessfully send");
					pw.close();
			}
}
