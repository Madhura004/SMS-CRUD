package com.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
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


@WebServlet(urlPatterns="/edit")
public class EditStudentServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
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
		
		RequestDispatcher rd = req.getRequestDispatcher("edit-student.jsp");
		rd.forward(req, resp);
	}

	@Override            //post to update/add the data in the database
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// post has the logic of updating the record
		int sid = Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("sname");
		Double marks=Double.parseDouble( req.getParameter("smarks"));
		int rollnum=Integer.parseInt(req.getParameter("srollnum"));
		
		System.out.println(name);
    	System.out.println(marks);
		System.out.println(rollnum);
		
		
		
		try {
			Connection connection = JDBCConnector.getConnection();
			String query ="update student set name=?,marks=?,rollnum=? where id=?";
			PreparedStatement prestatement= connection.prepareStatement(query);
			prestatement.setString(1, name);
			prestatement.setDouble(2, marks);
			prestatement.setInt(3, rollnum);
			prestatement.setInt(4, sid);
			
			//		Statement statement= connection.createStatement();
			System.out.println(4);
			//		String query = "update student set name='jay baba' where id=1";
			
			int row = prestatement.executeUpdate();   //affected row - is shown by executeUpdate
			if(row > 0) {
				System.out.println("Data updated !!!");
				
			}
			else {
				System.out.println("Something went wrong data is not updated !!!");
				
			}
			
			prestatement.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		resp.sendRedirect("list");
	}
	
	

}
