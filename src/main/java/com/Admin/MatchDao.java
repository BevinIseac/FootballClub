package com.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MatchDao {
    private Connection con;
    private PreparedStatement pst;
    private ResultSet rs;

    // Constructor to initialize database connection
    public MatchDao() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish a connection to the database
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/vsbdb", "root", "root");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Retrieve match details from the database
    public ResultSet retrieveMatch() {
        String sql = "SELECT title, place, date FROM matchdetails";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    // Store a match into the database
    public void storeData(Match m) {
        String sql = "INSERT INTO matchdetails (title, place, date) VALUES (?, ?, ?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, m.getTitle());
            pst.setString(2, m.getPlace());
            pst.setString(3, m.getDt());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Close resources
    public void close() {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
