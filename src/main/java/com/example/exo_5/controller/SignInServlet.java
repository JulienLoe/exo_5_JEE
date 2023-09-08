package com.example.exo_5.controller;

import com.example.exo_5.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static com.example.exo_5.data.FakeDB.users;

import java.io.IOException;
import java.util.Optional;

@WebServlet(name = "dogDetailsServlet", value = "/auth/signIn")
public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("mode", "Login");


            req.getRequestDispatcher("/WEB-INF/auth/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Optional<com.example.exo_5.model.User> us1 = users
                .stream()
                .filter(u -> u.getPassword().equals(password)).findFirst();

        if (username.equalsIgnoreCase(us1.get().getName()) && password.equalsIgnoreCase(us1.get().getPassword())) {
            req.getSession().setAttribute("connected", true);
            resp.sendRedirect(req.getContextPath() + "/private-content");
        } else {
            doGet(req, resp);
        }


    }


}
