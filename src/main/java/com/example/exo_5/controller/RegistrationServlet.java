package com.example.exo_5.controller;

import com.example.exo_5.data.FakeDB;
import com.example.exo_5.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

import static com.example.exo_5.data.FakeDB.users;


@WebServlet(name = "RegistrationServlet", value = "/auth/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("mode", "registration");

        req.getRequestDispatcher("/WEB-INF/auth/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User newUser = new User(
                username,
                password
        );

        users.add(newUser);

        req.getSession().setAttribute("connected", true);
        req.getSession().setAttribute("username", username);
        // resp.sendRedirect(req.getContextPath() + "/dogs/list");
        resp.sendRedirect(req.getContextPath() + "/private-content");
    }
}
