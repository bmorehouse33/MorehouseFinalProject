/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.morehousefinalproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

/**
 *
 * @author Brian Morehouse
 */
public class SQLiteConnection {
    
    Connection conn = null;    

    public  Connection connect() throws ClassNotFoundException {

        try {
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Brian Morehouse\\Documents\\NetBeansProjects\\MorehouseFinalProject\\MorehouseFinalProject\\src\\main\\java\\com\\morehousefinalproject\\db1.db");
            System.out.println("Connection to SQLite has been established.");

            Statement stmt = null;
            stmt = conn.createStatement();
            return conn;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;


        }

    }
    
    public void insertIntoBooking(String userEmail, String location, String date, String startTime, String endTime) throws SQLException, ClassNotFoundException{
        
        String sql = "INSERT INTO StudyRoomBooking(UserEmail, Location, Date, StartTime, EndTime) VALUES(?,?, ?, ?, ?)";
        try(Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, userEmail);
            pstmt.setString(2, location);
            pstmt.setString(3, date);
            pstmt.setString(4, startTime);
            pstmt.setString(5, endTime);
            pstmt.executeUpdate();
            conn.close();
        }
           
    }
    public void deleteFromBooking(int bookingID) throws SQLException, ClassNotFoundException{
        String sqlDelete = "DELETE FROM StudyRoomBooking WHERE BookingID=(?)";
        try(
                PreparedStatement pstmt = conn.prepareStatement(sqlDelete)){
            pstmt.setInt(1, bookingID);
            pstmt.executeUpdate();
            
        }
        
    }
   
        
    

}
