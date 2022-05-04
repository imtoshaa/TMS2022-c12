package by.teachmeskills.eshop.servlets;

import by.teachmeskills.eshop.exceptions.RequestParamNullException;
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
import static by.teachmeskills.eshop.utils.CRUDUtils.getUserByLoginAndPassword;
import static by.teachmeskills.eshop.utils.HttpRequestParamValidator.validateParamNotNull;

@WebServlet("/login")
public class ApplicationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("signin.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("username");
        String pass = req.getParameter("password");
        try {
            validateParamNotNull(login);
            validateParamNotNull(pass);
        } catch (RequestParamNullException e) {
            System.out.println(e.getMessage());
        }
        RequestDispatcher rd = req.getRequestDispatcher(checkReceivedUser(login, pass, req));
        rd.forward(req, resp);
    }

    private String checkReceivedUser(String login, String pass, HttpServletRequest request) {
        if (login != null && pass != null) {
            User user = getUserByLoginAndPassword(login, pass);
            if (user != null) {
                request.getSession().setAttribute("user", user);
                List<Category> categories = getAllCategories();
                request.setAttribute("categories", categories);
                return "home.jsp";
            }
        }
        return "signin.jsp";
    }
}
