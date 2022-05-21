package by.teachmeskills.eshop.servlets;

import by.teachmeskills.eshop.model.Product;
import by.teachmeskills.eshop.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import static by.teachmeskills.eshop.utils.CRUDUtils.getProductsByCategoryName;
import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

@WebServlet("/category")
public class CategoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (isAuthenticated(user)) {
            String categoryName = req.getParameter("categoryName");
            List<Product> products = getProductsByCategoryName(categoryName);
            req.setAttribute("categoryName", categoryName.toUpperCase(Locale.ROOT));
            req.setAttribute("products", products);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/category.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/signin.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
