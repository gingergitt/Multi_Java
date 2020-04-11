package com.sds;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/WebAppServlet", "/webapp" })
public class WebAppServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public WebAppServlet() {
        super();
        
    }

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("ip");
		String txt= request.getParameter("txt");
		
	
	}

}
