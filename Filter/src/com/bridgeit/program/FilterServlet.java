package com.bridgeit.program;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterServlet implements Filter{
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		PrintWriter pw=resp.getWriter();
		pw.print("invoke before filter");
		chain.doFilter(req, resp);
		pw.print("invoke after filter");
	}
	@Override
	public void destroy() {
			
	}
	

}
