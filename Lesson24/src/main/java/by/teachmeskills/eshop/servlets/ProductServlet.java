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

import static by.teachmeskills.eshop.utils.CRUDUtils.getProductById;
import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

@WebServlet("/product")
public class ProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");
        if (isAuthenticated(user)) {
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User user = (User) req.getSession().getAttribute("user");
        user.getCart().addProduct(CRUDUtils.getProductById(Integer.parseInt(id)));
        req.setAttribute("user", user);
        resp.sendRedirect("/cart");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/cart");
//        requestDispatcher.forward(req, resp);
//        не хочет перенаправлять вообще ни на какую страницу, только если сенд редирект
    }
}
