package by.teachmeskills.eshop.servlets;

import by.teachmeskills.eshop.model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.teachmeskills.eshop.utils.CRUDUtils.*;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/registration.html");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String info = req.getParameter("info");
        User test = getUserByLoginAndPassword(login, password);
        if (checkUserByLogin(login)) {
            User user = User.builder()
                    .login(login)
                    .password(password)
                    .name(name)
                    .surname(surname)
                    .info(info)
                    .build();
            registerUser(user);
            RequestDispatcher rd = req.getRequestDispatcher("/login");
            rd.forward(req, resp);
        } else {
            resp.getWriter().write("A user with this username already exists!");
        }
    }
}
