<%@page import="com.ey.entity.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
Product product = (Product) session.getAttribute("product");
%>
<body>
<form action="ProductServlet">
<input type="hidden" name="op" value="update" />
<input type="hidden" name="id" value="<%= product.getId() %>" />
Enter product name : <input type="text" name="name" value="<%= product.getName() %>" /> <br />
Enter price : <input type="number" name="price" value="<%= product.getPrice() %>" /> <br />
Enter quantity : <input type="number" name="quantity" value="<%= product.getQuantity() %>" /> <br />
<button type="submit">Update</button>
</form>
</body>
</html>