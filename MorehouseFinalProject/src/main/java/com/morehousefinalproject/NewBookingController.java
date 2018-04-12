/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.morehousefinalproject;

import java.io.IOException;
import java.io.PrintWriter;
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
    

     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
                
//        SQLiteConnection sqlCon= new SQLiteConnection();
//        String insertStatement = "INSERT INTO StudyRoomBooking(UserEmail, StudyRoomID, Date, StartTime, EndTime)"
//                + " VALUES('email','1', date, startTIme, endTime)";
//        String sql = "INSERT INTO warehouses(name,capacity) VALUES(?,?)";
//        try {
//            String date = request.getParameter("Date");
//            String location = request.getParameter("Location");
//            String room = request.getParameter("RoomNumber");
//            //Need to parse other studyRoom table to find studyroomID to put into studyRoomBooking table
//            
//            String startTime = request.getParameter("StartTime");
//            String endTime = request.getParameter("endTime");
//            
//            
//            Connection conn = sqlCon.connect();
//            
//            
//            
//            
//            
//            
//            
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(NewBookingController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        this.getServletContext().getRequestDispatcher("/WEB-INF/NewBookingView.jsp").include(request, response);
        
        
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
