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
public class DeleteEntryController extends HttpServlet {

    int bookingID;
    SQLiteConnection sqlConnect = new SQLiteConnection();
    Connection conn;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String urlData = request.getQueryString();
        String parcedData = urlData.substring(10);
        int bookingID = Integer.parseInt(parcedData);

        try {
            conn = sqlConnect.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DeleteEntryController.class.getName()).log(Level.SEVERE, null, ex);
        }

        PersistingData pd = PersistingData.getInstance();

        String storedEmail = pd.getUserEmail();

        Statement stmt = null;

        try {

            stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT UserEmail FROM StudyRoomBooking WHERE BookingID=" + bookingID + ";");
            String userEmail = rs.getString("UserEmail");

            if (userEmail.equals(storedEmail)) {
                sqlConnect.deleteFromBooking(bookingID);
                conn.close();
                request.getRequestDispatcher("/WEB-INF/DeleteSuccessView.jsp").forward(request, response);
            } else {
                conn.close();
                request.getRequestDispatcher("/WEB-INF/DeletionErrorView.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DeleteEntryController.class.getName()).log(Level.SEVERE, null, ex);
        }

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
