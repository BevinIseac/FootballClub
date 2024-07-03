package com.Admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterFormServlet")
public class RegisterFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html>");
		out.println("<head>");
		out.println("<head>");
		out.println("<link rel ='stylesheet' href='player.css'>");
		out.println("<body>");
		out.println("<center>");
		out.println("<marquee><h1><label class='ise'>Selected Players Info</h1></marquee>");
		out.println("<table border ='1'<tr><th> Name </th><th> Age </th><th> District </th><th> Position </th><th> Profile </th></tr>");
		ResultSet rs1 = new RegisterDao().RetrieveRegister();
		try {
			while(rs1.next()) {
				out.println("<tr><th>"+rs1.getString("Name")+"</th><th>"+rs1.getInt("Age")+"</th><th>"+rs1.getString("District")+"</th><th>"+rs1.getString("Position")+"</th><th>"+rs1.getBlob("Profile")+"</th><tr>");
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		out.println("</center></table></body></html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
