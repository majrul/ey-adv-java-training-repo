<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- <form action="ProductServlet?op=add"> -->
<form action="ProductServlet">
<input type="hidden" name="op" value="add" />
Enter product name : <input type="text" name="name" /> <br />
Enter price : <input type="number" name="price" /> <br />
Enter quantity : <input type="number" name="quantity" /> <br />
<button type="submit">Add</button>
</form>
</body>
</html>