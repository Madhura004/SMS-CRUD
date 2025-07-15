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
<div class="container">
	<%@ include file='navbar.html' %>
	</div>
<div class="container mt-5">
<h1 class="text-center">✍️(◔◡◔)Add Students Details Here</h1>

		<form action="add" method="POST">
			<div class="form-group">
				<label for="inputname"><h4>Student name</h4></label>
				<input type="text" name="sname" class="form-control"
					id="inputname" aria-describedby="emailhelp"
					placeholder="Enter Student Name" />
			</div>

			<div class="form-group">
				<label for="inputmarks"><h4>Student marks</h4></label>
				<input type="text" name="smarks" class="form-control"
					id="inputname" aria-describedby="emailhelp"
					placeholder="Enter Student Marks" />
			</div>

			<div class="form-group">
				<label for="inputmarks"><h4>Student rollnum</h4></label>
				<input type="text" name="srollnum" class="form-control"
					id="inputname" aria-describedby="emailhelp"
					placeholder="Enter Student Rollnum" />
			</div>


		
				<center><button type="submit" class="btn btn-primary">Save</button></center>
			

		</form>
		</div>
	
</body>
</html>