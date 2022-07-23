package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.entities.Category;
import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.services.impl.CategoryServiceImpl;
import by.teachmeskills.eshop.services.impl.UserServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.teachmeskills.eshop.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.REGISTRATION_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.BIRTHDAY;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.RequestParamsEnum.EMAIL;
import static by.teachmeskills.eshop.RequestParamsEnum.INFO;
import static by.teachmeskills.eshop.RequestParamsEnum.NAME;
import static by.teachmeskills.eshop.RequestParamsEnum.PASSWORD;
import static by.teachmeskills.eshop.RequestParamsEnum.SURNAME;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.RequestParamsEnum.USERNAME;

public class RegistrationPageCommandImpl implements BaseCommand {
    private static final Logger log = LogManager.getLogger(RegistrationPageCommandImpl.class);
    private final UserServiceImpl userService = new UserServiceImpl();
    private final CategoryServiceImpl categoryService = new CategoryServiceImpl();

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        String username = request.getParameter(USERNAME.getValue());
        String password = request.getParameter(PASSWORD.getValue());
        String name = request.getParameter(NAME.getValue());
        String surname = request.getParameter(SURNAME.getValue());
        String info = request.getParameter(INFO.getValue());
        String email = request.getParameter(EMAIL.getValue());
        String birthday = request.getParameter(BIRTHDAY.getValue());
        if (userService.checkUserByUsername(username)) {
            User user = User.builder()
                    .username(username)
                    .name(name)
                    .surname(surname)
                    .password(password)
                    .info(info)
                    .email(email)
                    .birthday(birthday)
                    .build();
            userService.create(user);
            user = userService.getUserByLoginAndPassword(username, password);
            request.getSession().setAttribute(USER.getValue(), user);
            List<Category> categories = categoryService.read();
            request.setAttribute(CATEGORIES.getValue(), categories);
            log.info("User " + username + "with password " + password + "was registered!");
            return HOME_PAGE.getPath();
        } else {
            return REGISTRATION_PAGE.getPath();
        }
    }
}
