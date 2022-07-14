package by.teachmeskills.eshop.utils;

import by.teachmeskills.eshop.CommandsEnum;
import by.teachmeskills.eshop.RequestParamsEnum;
import by.teachmeskills.eshop.commands.ActionsInShoppingCartCommandImpl;
import by.teachmeskills.eshop.commands.AddProductToCartCommandImpl;
import by.teachmeskills.eshop.commands.BaseCommand;
import by.teachmeskills.eshop.commands.CategoryRedirectCommandImpl;
import by.teachmeskills.eshop.commands.HomePageCommandImpl;
import by.teachmeskills.eshop.commands.MyPageCommandImpl;
import by.teachmeskills.eshop.commands.RedirectProductPageCommandImpl;
import by.teachmeskills.eshop.commands.RedirectToRegistrationPageCommandImpl;
import by.teachmeskills.eshop.commands.RedirectToShoppingCartCommandImpl;
import by.teachmeskills.eshop.commands.RegistrationPageCommandImpl;
import by.teachmeskills.eshop.commands.SearchPageCommandImpl;
import by.teachmeskills.eshop.commands.SignInCommandImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

import static by.teachmeskills.eshop.CommandsEnum.ACTION_IN_SHOPPING_CART;
import static by.teachmeskills.eshop.CommandsEnum.ADD_PRODUCT_TO_CART;
import static by.teachmeskills.eshop.CommandsEnum.CATEGORY_PAGE_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.HOME_PAGE_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.MY_PAGE_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.REDIRECT_PRODUCT_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.REDIRECT_SHOPPING_CART_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.REDIRECT_TO_REGISTRATION_PAGE;
import static by.teachmeskills.eshop.CommandsEnum.REGISTRATION_PAGE_COMMAND;
import static by.teachmeskills.eshop.CommandsEnum.SEARCH_PAGE;
import static by.teachmeskills.eshop.CommandsEnum.SIGN_IN_COMMAND;

public class CommandFactory {
    private static final Map<String, BaseCommand> COMMAND_LIST = new HashMap<>();

    static {
        COMMAND_LIST.put(HOME_PAGE_COMMAND.getCommand(), new HomePageCommandImpl());
        COMMAND_LIST.put(ACTION_IN_SHOPPING_CART.getCommand(), new ActionsInShoppingCartCommandImpl());
        COMMAND_LIST.put(SIGN_IN_COMMAND.getCommand(), new SignInCommandImpl());
        COMMAND_LIST.put(CATEGORY_PAGE_COMMAND.getCommand(), new CategoryRedirectCommandImpl());
        COMMAND_LIST.put(ADD_PRODUCT_TO_CART.getCommand(), new AddProductToCartCommandImpl());
        COMMAND_LIST.put(REDIRECT_SHOPPING_CART_COMMAND.getCommand(), new RedirectToShoppingCartCommandImpl());
        COMMAND_LIST.put(REDIRECT_PRODUCT_COMMAND.getCommand(), new RedirectProductPageCommandImpl());
        COMMAND_LIST.put(REGISTRATION_PAGE_COMMAND.getCommand(), new RegistrationPageCommandImpl());
        COMMAND_LIST.put(MY_PAGE_COMMAND.getCommand(), new MyPageCommandImpl());
        COMMAND_LIST.put(REDIRECT_TO_REGISTRATION_PAGE.getCommand(), new RedirectToRegistrationPageCommandImpl());
        COMMAND_LIST.put(SEARCH_PAGE.getCommand(), new SearchPageCommandImpl());
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        String commandKey = request.getParameter(RequestParamsEnum.COMMAND.getValue());
        if (commandKey == null || commandKey.isEmpty()) {
            commandKey = SIGN_IN_COMMAND.getCommand();
        }
        return COMMAND_LIST.get(commandKey);
    }

}

