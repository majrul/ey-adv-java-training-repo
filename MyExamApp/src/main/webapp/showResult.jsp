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
Integer score = (Integer) session.getAttribute("score");
%>
<h2>Congratulations, you have scored <%= score %> marks</h2>
</body>
</html>