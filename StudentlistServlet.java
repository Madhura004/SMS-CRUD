package com.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Student;
import com.util.JDBCConnector;


@WebServlet(urlPatterns="/list")
public class StudentlistServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection=null;
		Statement statement=null;
		
		List<Student> data=new ArrayList<>();
		try {
//			Connection connection1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb1", "root",  "WJ28@krhps");
//			System.out.println(3);
			
			 connection= JDBCConnector.getConnection();
			 statement= connection.createStatement();
			System.out.println(4);
			String query = "select * from student";
			ResultSet resultSet = statement.executeQuery(query);   //affected row - is shown by executeUpdate
			
			
			while(resultSet.next()) {                   //we used the while loop to make data in short
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Double marks = resultSet.getDouble("marks");
				int rollNum = resultSet.getInt("rollNum");
				Student s = new Student(id, name, marks, rollNum);
				data.add(s);
				
//				
//				System.out.println("Students name is: "+ name);
//				System.out.println("Students marks are: "+ marks);
//				System.out.println("Students roll number is: "+ rollNum);
//				System.out.println("---------------------------------------------------");
				
				
//					System.out.println(id + ">>"  +  name  +">>"  +  marks  +">>"  +  rollNum);	
		
	}
//	      System.out.println(data);
						
			
		}catch(Exception e) {
			System.out.println("There is a problem while fetching data from database");
		}finally {
			try {
				statement.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(data!=null) {
			req.setAttribute("data", data);
			
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("student-list.jsp");
		rd.forward(req, resp);
		}
	
	}

