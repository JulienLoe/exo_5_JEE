package com.example.exo_5.controller;


import com.example.exo_5.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.example.exo_5.data.FakeDB.users;

@WebServlet(name = "homeServlet", value = "/home")
    public class HomeServlet extends HttpServlet {


        @Override
        public void init() throws ServletException {

            User us1 = new User("John", "****");
            users.add(us1);
        }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/WEB-INF/homePage.jsp").forward(req, resp);
    }

    }
