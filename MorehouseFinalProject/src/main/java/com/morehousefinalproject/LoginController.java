/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.morehousefinalproject;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Iterator;
import static javafx.application.ConditionalFeature.WEB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.morehousefinalproject.UserModel;
import com.morehousefinalproject.UserRepo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Brian Morehouse
 */

public class LoginController extends HttpServlet {

//    @Autowired
//    private UserRepo userRepo;
    //private UserModel userModel;
    //private Iterable<UserModel> data;
    
     
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //get database username and password info
        //data= userRepo.findAll();
        

        
        String username=request.getParameter("username");  
        String password=request.getParameter("password");
               
        System.out.println(username+""+password );
        if(username != null && 
    		  !username.equals("") 
    		  && username.equals("jai") && 
    		  password != null && 
    		  !password.equals("") && 
    		  password.equals("123")){
            this.getServletContext().getRequestDispatcher("/WEB-INF/MainView.jsp").include(request, response);
        }
        else{
            this.getServletContext().getRequestDispatcher("/WEB-INF/LoginErrorView.jsp").include(request, response);
        }
               
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher("/WEB-INF/LoginView.jsp").include(request, response);
              
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
