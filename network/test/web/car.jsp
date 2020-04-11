<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
String lat = request.getParameter("lat");
String lng = request.getParameter("lng");
String id = request.getParameter("id");

System.out.println(id+" "+lat+" "+lng);

%>