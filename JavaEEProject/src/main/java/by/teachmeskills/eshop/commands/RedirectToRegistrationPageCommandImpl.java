package by.teachmeskills.eshop.commands;

import javax.servlet.http.HttpServletRequest;

import static by.teachmeskills.eshop.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.PagesPathEnum.REGISTRATION_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;

public class RedirectToRegistrationPageCommandImpl implements BaseCommand{
    @Override
    public String execute(HttpServletRequest request) throws Exception {
        if (request.getSession().getAttribute(USER.getValue()) != null) {
            return HOME_PAGE.getPath();
        }
        return REGISTRATION_PAGE.getPath();
    }
}
