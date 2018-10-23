package com.codegym.controller;

import sun.rmi.server.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("Username");
        String password = request.getParameter("Password");

        boolean isUsernameEqualsNull = username==null?true:false;
        boolean isPasswordEqualsNull = password==null?true:false;
        boolean isAcceptUserName = username.equals("admin")&& password.equals("admin")?true:false;
        String message = "", status = "";

        if(isAcceptUserName){
            status = "bg-access";
            response.sendRedirect("/products");
        }
        else{
            message = "Your 'username' or 'password' is not valid, please try again later!!";
            status = "bg-danger";
            request.setAttribute("message", message);
            request.setAttribute("status", status);
            RequestDispatcher dispatcher =request.getRequestDispatcher("index.jsp") ;
            dispatcher.forward(request,response);
            //response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
