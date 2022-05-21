package by.teachmeskills.eshop.servlets;

import by.teachmeskills.eshop.model.Category;
import by.teachmeskills.eshop.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static by.teachmeskills.eshop.utils.CRUDUtils.getAllCategories;
import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (isAuthenticated(user)) {
            List<Category> categories = getAllCategories();
            req.setAttribute("categories", categories);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/home.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/signin.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
