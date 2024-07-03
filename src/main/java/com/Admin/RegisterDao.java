package com.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RegisterDao {
	Connection con;
	PreparedStatement pst;
	ResultSet rs1;

public RegisterDao (){
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	    con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vsbdb", "root", "root");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public ResultSet RetrieveRegister() {
	String sql = "Select name, age, district, position, profile from registeredplayers";
	try {
		pst=con.prepareStatement(sql);
		rs1 = pst.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs1;
	
}
public void Storedata(Register r) {
	// TODO Auto-generated method stub
String sql = "insert into registeredplayers(Name, Age, District, Position, Profile) values(?, ?, ?, ?, ?) ";
	
	try {
		pst = con.prepareStatement(sql);
		pst.setString(1, r.getName());
		pst.setInt(2, r.getAge());
		pst.setString(3, r.getDistrict());
		pst.setString(4, r.getPosition());
		pst.setBlob(5, r.getProfile());
		pst.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
	
