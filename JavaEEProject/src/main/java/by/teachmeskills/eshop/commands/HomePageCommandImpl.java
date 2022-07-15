package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.entities.Category;
import by.teachmeskills.eshop.exceptions.CommandException;
import by.teachmeskills.eshop.services.impl.CategoryServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.teachmeskills.eshop.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORIES;

public class HomePageCommandImpl implements BaseCommand{
    private static final Logger log = LogManager.getLogger(HomePageCommandImpl.class);
    private final CategoryServiceImpl categoryService = new CategoryServiceImpl();
    @Override
    public String execute(HttpServletRequest request) throws Exception {
        List<Category> categories = categoryService.read();
        request.setAttribute(CATEGORIES.getValue(), categories);
        log.info("Redirect to HomePage");
        return HOME_PAGE.getPath();
    }
}
