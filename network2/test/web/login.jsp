<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String id = request.getParameter("id");
String pwd = request.getParameter("pwd");
if(id.equals("qqq") && pwd.equals("111")){
	out.print("1");
}else{
	out.print("0");
}

%>