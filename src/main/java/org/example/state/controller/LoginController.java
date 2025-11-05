package org.example.state.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getMethod());
        System.out.println(req.getParameter("msg"));
        System.out.println(req.getHeaderNames());

        req.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
    }
}
