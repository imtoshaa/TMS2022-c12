package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.domain.Category;
import by.teachmeskills.eshop.exceptions.CommandException;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.teachmeskills.eshop.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.RequestParamsEnum.CATEGORIES;
import static by.teachmeskills.eshop.utils.CRUDUtils.getAllCategories;

public class HomePageCommandImpl implements BaseCommand{

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        List<Category> categories = getAllCategories();
        request.setAttribute(CATEGORIES.getValue(), categories);
        return HOME_PAGE.getPath();
    }
}
