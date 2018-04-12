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

    public static Connection connect() throws ClassNotFoundException {

        try {
            Class.forName("org.sqlite.JDBC");

            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Brian Morehouse\\Documents\\NetBeansProjects\\MorehouseFinalProject\\MorehouseFinalProject\\src\\main\\java\\com\\morehousefinalproject\\db1.db");
            System.out.println("Connection to SQLite has been established.");

            Statement stmt = null;
            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Users;");
            while (rs.next()) {
                String FirstName = rs.getString("FirstName");
                String LastName = rs.getString("LastName");
                String Username = rs.getString("Username");
                String Password = rs.getString("Password");
                System.out.println("First Name = " + FirstName);
                System.out.println("Last Name = "+LastName);
                System.out.println("Username = "+Username);
                System.out.println("Password = "+Password);
                
            }

            return conn;
            //String url;
            // create a connection to the database
            // url = "jdbc:sqlite:C:\\Users\\Brian Morehouse\\Documents\\NetBeansProjects\\MorehouseFinalProject\\MorehouseFinalProject\\src\\main\\java\\com\\morehousefinalproject\\db1.db";            
            //conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
//        } finally {
//            try {
//                if (conn != null) {
//                    conn.close();
//                }
//            } catch (SQLException ex) {
//                System.out.println(ex.getMessage());
//            }

        }

    }
    
    
    

}
