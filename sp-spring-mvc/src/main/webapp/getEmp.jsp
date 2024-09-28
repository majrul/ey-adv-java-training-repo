<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>${ message }</h3>
<form method="post" action="get-emp">
Enter empno : <input type="number" name="empno" /> <br />
<button type="Submit">Fetch Employee Details</button>
</form>
</body>
</html>