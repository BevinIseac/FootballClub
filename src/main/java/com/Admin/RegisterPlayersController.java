package com.Admin;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/RegisterPlayersCont")
@MultipartConfig(maxFileSize=16177215)
public class RegisterPlayersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String driver ="com.mysql.cj.jdbc.Driver";
	String url ="jdbc:mysql://localhost:3306/vsbdb";
	String unm = "root";
	String pwd = "root";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name").trim();
		String a = request.getParameter("age").trim();
		int age=Integer.parseInt(a);
		String district = request.getParameter("district").trim();
		String position = request.getParameter("position").trim();
		InputStream istrm = null;
		Part fp = request.getPart("profile");
			if(fp!= null) {
				System.out.println(fp.getName());
				System.out.println(fp.getSize());
				System.out.println(fp.getContentType());
				istrm=fp.getInputStream();
		}
			Connection con = null;
			String msg = null;
		try{
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			con =DriverManager.getConnection(url,unm,pwd);
		String sql = "insert into registeredplayers (Name, Age, District, Position, Profile) values(?, ?, ?, ?, ?) ";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setInt(2, age);
		pst.setString(3, district);
		pst.setString(4, position);
		if(istrm!= null) {
			pst.setBlob(5, istrm);
		}
		int res = pst.executeUpdate();
		if(res>0) {
			msg ="Player data upload Successfully";
		}
		
		con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	ArrayList<String> list = new ArrayList<String>();
	
	if(name.length()==0) 
		list.add("Enter the title");
	if(age<15)
		list.add("Enter the place");
	if(district.length()==0)
		list.add("Enter the date of the match");
	if(position.length()==0)
		list.add("Enter the date of the match");
	if(!list.isEmpty()) {
		request.setAttribute("error", list);
		RequestDispatcher rd = request.getRequestDispatcher("AddPlayers");
		rd.forward(request, response);
	}
	
	Register r = new Register(name, age, district, position, istrm );
	RegisterDao rdd = new RegisterDao();
	 rdd.Storedata(r);
	
				request.setAttribute("msg", msg);
				
				getServletContext().getRequestDispatcher("/Message.html").forward(request,response);
	}

	
		
		
	}


