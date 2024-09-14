<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Info : <%= application.getInitParameter("info") %> <br />
<%
Map<String, Integer> hitCounterMap = (Map<String, Integer>) application.getAttribute("hitCounterMap");
for(Map.Entry<String,Integer> entry : hitCounterMap.entrySet()) {
%>
	URI : <%= entry.getKey() %>, Hits : <%= entry.getValue() %> <br />
<%
}
%>

<br />
Total hits : <%= application.getAttribute("hitCounter") %>
</body>
</html>