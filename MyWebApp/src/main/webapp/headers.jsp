<%@page import="java.time.LocalTime"%>
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
	String agent = request.getHeader("user-agent");
	//response.setHeader("refresh", "1");
	//response.setHeader("refresh", "5;url=https://www.google.com");
	response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
	
%>
<h2>You are currently using <%= agent %></h2>

<h2>Time right now <%= LocalTime.now() %></h2>
</body>
</html>