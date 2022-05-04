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

import static by.teachmeskills.eshop.utils.CRUDUtils.*;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (user != null && checkUser(user)) {
            String id = req.getParameter("id");
            Product product = getProductById(Integer.parseInt(id));
            req.setAttribute("product", product);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/product.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/signin.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
