package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.User;
import by.teachmeskills.eshop.exceptions.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.teachmeskills.eshop.PagesPathEnum.REGISTRATION_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.PASSWORD;
import static by.teachmeskills.eshop.RequestParamsEnum.USERNAME;
import static by.teachmeskills.eshop.utils.CRUDUtils.checkUserByUsername;
import static by.teachmeskills.eshop.utils.CRUDUtils.registerUser;

public class RegistrationPageCommandImpl implements BaseCommand{
    private static final Logger log = LogManager.getLogger(RegistrationPageCommandImpl.class);
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String username = request.getParameter(USERNAME.getValue());
        String password = request.getParameter(PASSWORD.getValue());
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        String info = request.getParameter("info");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");
        if (checkUserByUsername(username)) {
            User user = new User(username, name,surname,password,info,email,birthday);
            registerUser(user);
            log.info("User " + username + "with password " + password + "was registered!");
            return SIGN_IN_PAGE.getPath();
        } else {
            return REGISTRATION_PAGE.getPath();
        }
    }
}
