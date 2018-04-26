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

/**
 *
 * @author Brian Morehouse
 */
public class MainViewController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    String emailText;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        emailText = request.getParameter("email");
        if ((emailText == null) || (emailText == "email")) {
            this.getServletContext().getRequestDispatcher("/WEB-INF/UserInfo.html").include(request, response);
        } else {
            PersistingData tmp = PersistingData.getInstance();
            if (emailText.equals("email")) {

                System.out.println(emailText);
            } else {
                tmp.StoreData(emailText);
            }

            this.getServletContext().getRequestDispatcher("/WEB-INF/MainView.jsp").include(request, response);
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
