<%@page import="com.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file='base.html' %>
</head>	
<body>

<%
Student s= (Student) request.getAttribute("obj");
%>

	<div>
	<%@ include file='navbar.html' %>
	</div>
	
	<div class="container">
	<h1>Are you sure you want to delete : "<%=s.getName() %>" ?</h1>
	
	<form action="delete?id=<%=s.getId() %>" method="POST">
	<input type="submit" value="YES">
	</form>
	
	<a href="list">NO</a>
	
	
	</div>
</body>
</html>