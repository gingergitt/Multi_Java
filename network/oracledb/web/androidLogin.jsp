<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@page import="com.db.LoginDB"%>

<%
LoginDB loginDB = LoginDB.getInstance();
	
   String id = request.getParameter("id");
   String pwd = request.getParameter("pwd");
   
	String result= loginDB.loginnDB(id,pwd);
 	System.out.println("---------------------");
 	System.out.println(result);
 

 out.print(result);

 	 
   
   
   
   
   
   
   
   
   
   
   
%>