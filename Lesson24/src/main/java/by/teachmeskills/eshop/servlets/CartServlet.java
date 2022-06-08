package by.teachmeskills.eshop.servlets;

import by.teachmeskills.eshop.model.Product;
import by.teachmeskills.eshop.model.User;
import by.teachmeskills.eshop.utils.CRUDUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (isAuthenticated(user)) {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cart.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/signin.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (req.getParameter("action") != null) {
            String action = req.getParameter("action");
            switch (action) {
                case "clear" -> user.getCart().clear();
                case "buy" -> user.getCart().buy();
            }
        }
        if (req.getParameter("remove") != null) {
            user.getCart().removeProduct(Integer.parseInt(req.getParameter("remove")));
        }
        req.setAttribute("user", user);
        resp.sendRedirect("/cart");
    }
}
