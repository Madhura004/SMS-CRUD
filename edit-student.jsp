<%@page import="com.entity.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file='base.html'%>
</head>
<body>
	<%
	Student s = (Student) request.getAttribute("obj");
	%>
	<div>
		<%@ include file='navbar.html'%>
	</div>
	<div class="container mt-5">
		<h1 class="text-center">Edit Students Details Here</h1>
		<form action="edit?id=<%=s.getId()%>" method="POST">
			<div class="form-group">
				<label for="inputname">Student name</label> <input type="text"
					name="sname" value="<%=s.getName()%>" class="form-control"
					id="inputname" aria-describedby="emailhelp"
					placeholder="Enter Student Name" />
			</div>

			<div class="form-group">
				<label for="inputmarks">Student marks</label> <input type="text"
					name="smarks" value="<%=s.getMarks()%>" class="form-control"
					id="inputname" aria-describedby="emailhelp"
					placeholder="Enter Student Marks" />
			</div>

			<div class="form-group">
				<label for="inputmarks">Student rollnum</label> <input type="text"
					name="srollnum" value="<%=s.getrollnum()%>" class="form-control"
					id="inputname" aria-describedby="emailhelp"
					placeholder="Enter Student Rollnum" />
			</div>



			<center>
				<button type="submit" class="btn btn-primary">Edit</button>
			</center>


		</form>
	</div>

</body>
</html>