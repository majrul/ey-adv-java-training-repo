<%@page import="com.ey.entity.Product"%>
<%@page import="java.util.List"%>
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
List<Product> list = (List<Product>) session.getAttribute("listOfProducts");
for(Product product : list) {
%>
	ID : <%= product.getId() %> <br />
	Name : <%= product.getName() %> <br />
	Price : <%= product.getPrice() %> <br />
	Quantity : <%= product.getQuantity() %> <br />
	<hr />
<%
}
%>
</body>
</html>