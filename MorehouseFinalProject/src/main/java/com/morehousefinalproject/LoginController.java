/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.morehousefinalproject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Brian Morehouse
 */

public class LoginController extends HttpServlet {
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pst=null;

//    @Autowired
//    private UserRepo userRepo;
    //private UserModel userModel;
    //private Iterable<UserModel> data;
    
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //get database username and password info
        //data= userRepo.findAll();
        

        
//        String username=request.getParameter("username");  
//        String password=request.getParameter("password");
//               
//        System.out.println(username+""+password );
//        if(username != null && 
//    		  !username.equals("") 
//    		  && username.equals("user") && 
//    		  password != null && 
//    		  !password.equals("") && 
//    		  password.equals("user")){
//            this.getServletContext().getRequestDispatcher("/WEB-INF/MainView.jsp").include(request, response);
//        }
//        else{
//            this.getServletContext().getRequestDispatcher("/WEB-INF/LoginErrorView.jsp").include(request, response);
//        }
//               
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        
//        try {
//            conn=SQLiteConnection.connect();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
        
        
        
//        SQLiteConnection sqlConnection = new SQLiteConnection();
//        sqlConnection.connect();
        
        
        //this.getServletContext().getRequestDispatcher("/WEB-INF/LoginView.html").include(request, response);
                      
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
