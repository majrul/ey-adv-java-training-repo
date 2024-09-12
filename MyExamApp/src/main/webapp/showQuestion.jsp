<%@page import="com.ey.exam.core.Option"%>
<%@page import="java.util.List"%>
<%@page import="com.ey.exam.core.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="CalculateScoreServlet">
<%
Question question = (Question) session.getAttribute("question");
List<Option> options = question.getOptions();
%>
<h1><%= question.getText() %></h1>
<%
int opNo = 0;
for(Option option : options) {
%>
	<h3><input type="radio" name="op" value="<%= opNo++ %>" /><%= option.getText() %></h3>
<%
}	
%>
<button type="submit">NEXT QUESTION</button>
<!-- <a href="QuestionLoaderServlet">NEXT QUESTION</a> -->
</form>
</body>
</html>