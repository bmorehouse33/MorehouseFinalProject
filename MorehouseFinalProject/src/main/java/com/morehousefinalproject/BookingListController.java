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
public class BookingListController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        this.getServletContext().getRequestDispatcher("/WEB-INF/BookingListView.jsp").include(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        SQLiteConnection sqlCon = new SQLiteConnection();

        String tableList = "";
        Statement stmt = null;
        Connection conn;
        try {
            conn = sqlCon.connect();

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM StudyRoomBooking;");

            while (rs.next()) {
                String userEmail = rs.getString("UserEmail");
                String location = rs.getString("Location");
                String date = rs.getString("Date");
                String startTime = rs.getString("StartTime");
                String endTime = rs.getString("EndTime");
                int bookingID = rs.getInt("BookingID");

                tableList = tableList + "<tr><td align=\"left\">" + userEmail + "</td>"
                        + "<td align=\"left\">" + location + "</td>"
                        + "<td name='date' align=\"left\">" + date + "</td>"
                        + "<td align=\"left\">" + startTime + "</td>"
                        + "<td align=\"left\">" + endTime + "</td>"
                        + "<td align=\"left\"><a href='http://localhost:8080/MorehouseFinalProject/DeleteEntry?bookingID=" + bookingID + "'><p>Delete</p></a></td></tr>";

            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(NewBookingController.class.getName()).log(Level.SEVERE, null, ex);
        }

        StringBuilder tableView = new StringBuilder();
        tableView.append("<table border= 1px solid black>"
                + "<tr><th>Email</th>"
                + "<th>Location</th>"
                + "<th>Date</th>"
                + "<th>StartTime</th>"
                + "<th>EndTime</th>"
                + "</tr>"
                + tableList
                + "</table>");
        request.setAttribute("BookingList", tableView);
        request.getRequestDispatcher("/WEB-INF/BookingListView.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
