package com.app;

import java.io.IOException;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.util.JDBCConnector;

@WebServlet(urlPatterns = "/add")
public class AddStudentServlet extends HttpServlet {

	@Override
	protected void  doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//	System.out.println("welcome in the world of getmethod()✍️(◔◡◔)");
//	show a form in get method
		RequestDispatcher rd = req.getRequestDispatcher("add-form.jsp");
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

          //getting data form from client /html
		String name=req.getParameter("sname");
		Double marks=Double.parseDouble( req.getParameter("smarks"));
		int rollnum=Integer.parseInt(req.getParameter("srollnum"));
		
//		System.out.println(name);
//    	System.out.println(marks);
//		System.out.println(rollnum);
		
		Connection connection = null;
		PreparedStatement prestatement = null;
				
	
		        try {
		        	connection= JDBCConnector.getConnection();
					String query = "insert into student(name, marks, rollNum) values (?, ?, ?)";
					prestatement=connection.prepareStatement(query);
					prestatement.setString(1, name);                                   
					prestatement.setDouble(2,marks );
					prestatement.setInt(3, rollnum);
					
					System.out.println(4);		
					int row = prestatement.executeUpdate();
					if(row > 0) {
						System.out.println("Data inserted !!!");
						
					}else {
						System.out.println("Something went wrong data is not inserted !!!");
						
					}
					
					resp.sendRedirect("list");
					
				} catch (Exception e) {
					System.out.println("There is a problem while adding data to the database");
				    e.printStackTrace();
				}finally {
					if(prestatement !=null) {
						try {
							prestatement.close();
						} catch (SQLException e) {
							
							e.printStackTrace();
						}
						
					}

		}
				
	}	
}
