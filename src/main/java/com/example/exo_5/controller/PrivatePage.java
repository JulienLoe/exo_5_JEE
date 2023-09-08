package com.example.exo_5.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "restrictedContentServlet", value = "/private-content")
public class PrivatePage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Boolean isConnected = (Boolean) (req.getSession().getAttribute("connected") != null ? req.getSession().getAttribute("connected") : false);
        String username= (String) req.getSession().getAttribute("username");

        if (isConnected) {
            req.setAttribute("username", username);
            req.getRequestDispatcher("/WEB-INF/privatePage.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }
}
