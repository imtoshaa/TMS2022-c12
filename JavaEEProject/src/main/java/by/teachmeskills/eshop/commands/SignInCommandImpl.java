package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Category;
import by.teachmeskills.eshop.domain.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.exceptions.RequestParamNullException;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import static by.teachmeskills.eshop.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.RequestParamsEnum.PASSWORD;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.RequestParamsEnum.USERNAME;
import static by.teachmeskills.eshop.utils.CRUDUtils.getAllCategories;
import static by.teachmeskills.eshop.utils.CRUDUtils.getUserByLoginAndPassword;
import static by.teachmeskills.eshop.utils.HttpRequestParamValidator.validateParamNotNull;

public class SignInCommandImpl implements BaseCommand {
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String username = request.getParameter(USERNAME.getValue());
        String password = request.getParameter(PASSWORD.getValue());
        try {
            System.out.println("логин");
            validateParamNotNull(username);
            System.out.println("пароль");
            validateParamNotNull(password);
        } catch (RequestParamNullException e) {
            System.out.println(e.getMessage());
        }
        return checkReceivedUser(username, password, request);
    }

    private String checkReceivedUser(String username, String password, HttpServletRequest request) {
        User user = getUserByLoginAndPassword(username, password);
        if (user != null) {
            request.getSession().setAttribute(USER.getValue(), user);
            List<Category> categories = getAllCategories();
            request.setAttribute(CATEGORIES.getValue(), categories);
            return HOME_PAGE.getPath();
        }
        return SIGN_IN_PAGE.getPath();
    }
}