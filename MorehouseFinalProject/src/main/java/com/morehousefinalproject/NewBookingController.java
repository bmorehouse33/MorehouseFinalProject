/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.morehousefinalproject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Brian Morehouse
 */
public class NewBookingController extends HttpServlet {

    String date;
    String location;
    String userEmail;
    String startTime;
    String endTime;
    MonitorBooking mb;
    boolean testDB;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        SQLiteConnection sqlCon = new SQLiteConnection();
        Connection conn = null;
        try {
            conn = sqlCon.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NewBookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        date = request.getParameter("Date");
        if (date != null && date != "") {
            location = request.getParameter("Location");
            PersistingData tmp = PersistingData.getInstance();
            String currentEmail = tmp.getUserEmail();
            userEmail = currentEmail;
            startTime = request.getParameter("StartTime");
            endTime = request.getParameter("EndTime");

        }

        try {
            if (date != null && date != "") {
                mb = new MonitorBooking();
                testDB = mb.validateDB(conn, location, startTime, endTime, date);
                if (testDB == true) {
                    sqlCon.insertIntoBooking(userEmail, location, date, startTime, endTime);

                } else {
                    if (date != null) {

                        StringBuilder errorMessage = new StringBuilder();
                        errorMessage.append("<p><font color=\"red\">The input you have selected is invalid. "
                                + "Try a different location, time, or date.</font></p>");

                        request.setAttribute("errorMessage", errorMessage);

                    }
//                    
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(NewBookingController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String data = null;
        Statement stmt = null;

        try {

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM StudyRoom;");
            while (rs.next()) {
                String Location = rs.getString("Location");
                data = data + "<option>" + Location + "</option>\n";
            }

        } catch (SQLException ex) {
            Logger.getLogger(NewBookingController.class.getName()).log(Level.SEVERE, null, ex);
        }

        StringBuilder html = new StringBuilder();
        html.append("<select name=\"Location\" value=\"Location\">\n"
                + data
                + "</select>");
        request.setAttribute("dropdown", html);

        if (testDB == true) {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(NewBookingController.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("/WEB-INF/SuccessfulBooking.jsp").forward(request, response);
            testDB = false;

        } else {

            request.getRequestDispatcher("/WEB-INF/NewBookingView.jsp").forward(request, response);
            try {

                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(NewBookingController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        request.getRequestDispatcher("/WEB-INF/NewBookingView.jsp").forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
