<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String str = "Welcome to JSP";
%>
<h1><%= str %></h1>
<h2>Today's Date is <%= LocalDate.now() %></h2>
<div style="text-align:center">
<%
	for(int i=0; i<10; i++) {
%>
		Hello World <br />
<%
	}
%>
</div>
</body>
</html>