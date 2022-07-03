package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Category;
import by.teachmeskills.eshop.exceptions.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.teachmeskills.eshop.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.utils.CRUDUtils.getAllCategories;

public class HomePageCommandImpl implements BaseCommand{
    private static final Logger log = LogManager.getLogger(HomePageCommandImpl.class);
    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<Category> categories = getAllCategories();
        request.setAttribute(CATEGORIES.getValue(), categories);
        log.info("Redirect to HomePage");
        return HOME_PAGE.getPath();
    }
}
