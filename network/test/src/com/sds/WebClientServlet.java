package com.sds;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tcpip2.Client;
import tcpip2.Msg;

@WebServlet({ "/WebClientServlet", "/webclient" })

public class WebClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Client client;

	public WebClientServlet() {
		
			try {
				client = new Client ("70.12.225.34",8888);
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ip = request.getParameter("ip");
		String txt = request.getParameter("txt");

		Msg msg = null;
		
		if(ip == null|| ip.equals("")) {
			msg = new Msg("WebAdmin",txt,null);
		}else {
			msg = new Msg("WebAdmin",txt,ip);
			
		}
//		client.startClient(msg);
	}

}
