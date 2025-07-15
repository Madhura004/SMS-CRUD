package com.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.Student;
import com.util.JDBCConnector;


@WebServlet(urlPatterns = "/delete")
public class DeleteStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("I am inside the getmethod()");
		
		int sid = Integer.parseInt(req.getParameter("id"));
		// System.out.println(id);
		Connection connection=null;
		PreparedStatement statement=null;
		Student s= null;
//		List<Student> data=new ArrayList<>();
		try {
//			Connection connection1 =DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb1", "root",  "WJ28@krhps");
//			System.out.println(3);
			
			 connection= JDBCConnector.getConnection();
			 String query = "select * from student where id=?";
			 statement= connection.prepareStatement(query);
			 statement.setInt(1, sid);   //sid is returned from url/form
			 
			System.out.println(4);
			
			ResultSet resultSet = statement.executeQuery();   //affected row - is shown by executeUpdate
			
			
			while(resultSet.next()) {                   //we used the while loop to make data in short
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				Double marks = resultSet.getDouble("marks");
				int rollNum = resultSet.getInt("rollNum");
				s = new Student(id, name, marks, rollNum);
//				data.add(s);
				
//				
//				System.out.println("Students name is: "+ name);
//				System.out.println("Students marks are: "+ marks);
//				System.out.println("Students roll number is: "+ rollNum);
//				System.out.println("---------------------------------------------------");
				
				
//					System.out.println(id + ">>"  +  name  +">>"  +  marks  +">>"  +  rollNum);	
		
	}
//	      System.out.println(data);
			System.out.println(s);
						
			
		}catch(Exception e) {
			System.out.println("There is a problem while fetching data from database");
		}finally {
			try {
				statement.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
//		if(data!=null) {
//			req.setAttribute("data", data);
//		}
		if(s!=null) {
		req.setAttribute("obj", s);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("delete.jsp");
		rd.forward(req, resp);
	}
	

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("I am in the postmethod()");
		
		//getting student id from url : delete?id=1
		int sid = Integer.parseInt(req.getParameter("id"));
		try {
			
			Connection connection = JDBCConnector.getConnection();
			 
			PreparedStatement prestatement= connection.prepareStatement("delete from student where id=?");
			prestatement.setInt(1, sid);
//			System.out.println("Enter student id to delete the student:"); 
//			prestatement.setInt(1, sc.nextInt());
//			System.out.println(4);
//			String query = "delete from student where id=1";
			int row = prestatement.executeUpdate();   //affected row - is shown by executeUpdate
			if(row > 0) {
				System.out.println("Data deleted !!!");
				
			}else {
				System.out.println("Something went wrong data is not deleted !!!");
				
			}
			
			prestatement.close(); 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("There is problem in deleting object");
		}
		
		resp.sendRedirect("list");
	}

	
	
}
