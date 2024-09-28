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
<form method="post" action="add-emp">
Enter name : <input type="text" name="name" /> <br />
Enter date of joining : <input type="date" name="dateOfJoining" /> <br />
Enter salary : <input type="number" name="salary" /> <br />
<button type="Submit">Add Employee</button>
</form>
</body>
</html>