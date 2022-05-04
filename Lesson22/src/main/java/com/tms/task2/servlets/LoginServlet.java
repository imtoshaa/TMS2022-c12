package com.tms.task2.servlets;

import com.tms.task2.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.tms.task2.task1.utils.AdminPasswordConstant.ADMIN_EMAIL;
import static com.tms.task2.task1.utils.AdminPasswordConstant.ADMIN_PASS;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/login.html");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("pass");
        if (!ADMIN_EMAIL.equals(email) || !ADMIN_PASS.equals(password)) {
            resp.sendRedirect("/login.html");
        } else {
            req.getSession().setAttribute("user", new User(ADMIN_EMAIL, ADMIN_PASS));
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/calculate.html");
            requestDispatcher.forward(req, resp);
        }
    }
}