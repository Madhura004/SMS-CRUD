
<%@page import="com.entity.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file='base.html' %>
</head>
<body>
<%
  ArrayList<Student> data = (ArrayList<Student>) request.getAttribute("data");
// out.println(data);
%>
<div class="container">
	<%@ include file='navbar.html' %>
</div>
	<div class="container">
	<h1 class="text-center">📃List of Students</h1>
	<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">NAME</th>
      <th scope="col">MARKS</th>
      <th scope="col">ROLL NUM</th>
      <th scope="col">EDIT</th>
      <th scope="col">DELETE</th>
    </tr>
  </thead>
  <tbody>
  <% for(Student obj : data){ %>
    <tr>
      <th scope="row"><%= obj.getId() %>1</th>
      <td><%= obj.getName() %></td>
      <td><%= obj.getMarks() %></td>
       <td><%= obj.getrollnum() %></td>
      
      
       <td><a href="edit?id=<%= obj.getId() %>" class="btn btn-success btn-sm">Edit+</a></td>
        <td><a href="delete?id=<%= obj.getId() %>" class="btn btn-primary btn-sm">Delete+</a></td>
    </tr>
    <%
  }
    %>
  </tbody>
</table>	
	</div>
</body>
</html>