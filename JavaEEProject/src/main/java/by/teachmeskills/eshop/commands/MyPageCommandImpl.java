package by.teachmeskills.eshop.commands;

import by.teachmeskills.eshop.PagesPathEnum;
import by.teachmeskills.eshop.domain.entities.Order;
import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.services.impl.OrderServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

import static by.teachmeskills.eshop.RequestParamsEnum.ORDER_HISTORY;
import static by.teachmeskills.eshop.RequestParamsEnum.USER;
import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

public class MyPageCommandImpl implements BaseCommand{

    private final OrderServiceImpl orderService = new OrderServiceImpl();
    private static final Logger log = LogManager.getLogger(MyPageCommandImpl.class);

    @Override
    public String execute(HttpServletRequest request) throws Exception {
        User user = (User) request.getSession().getAttribute(USER.getValue());
        if (isAuthenticated(user)) {
            Map<Integer, Order> sss = orderService.getUserOrderById(user.getId());
            request.setAttribute(ORDER_HISTORY.getValue(), sss);

            log.info("Redirect to my page");
            return PagesPathEnum.MY_PAGE.getPath();
        } else {
            return PagesPathEnum.SIGN_IN_PAGE.getPath();
        }
    }
}
