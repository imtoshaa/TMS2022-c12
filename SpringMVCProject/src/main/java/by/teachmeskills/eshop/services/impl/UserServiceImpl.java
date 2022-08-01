package by.teachmeskills.eshop.services.impl;

import by.teachmeskills.eshop.dao.ICategoryDao;
import by.teachmeskills.eshop.dao.IOrderDao;
import by.teachmeskills.eshop.dao.IUserDao;
import by.teachmeskills.eshop.dao.impl.CategoryDaoImpl;
import by.teachmeskills.eshop.dao.impl.OrderDaoImpl;
import by.teachmeskills.eshop.dao.impl.UserDaoImpl;
import by.teachmeskills.eshop.domain.entities.Category;
import by.teachmeskills.eshop.domain.entities.Order;
import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.services.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import static by.teachmeskills.eshop.utils.EshopConstants.CATEGORIES;
import static by.teachmeskills.eshop.utils.EshopConstants.ORDER_HISTORY;
import static by.teachmeskills.eshop.utils.PagesPathEnum.HOME_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.MY_PAGE;
import static by.teachmeskills.eshop.utils.PagesPathEnum.SIGN_IN_PAGE;
import static by.teachmeskills.eshop.utils.EshopConstants.USER;
import static by.teachmeskills.eshop.utils.UserAuthenticationUtils.isAuthenticated;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserDao userDao = new UserDaoImpl();
    private final ICategoryDao categoryDao = new CategoryDaoImpl();
    private final IOrderDao orderDao = new OrderDaoImpl();

    @Override
    public void create(User entity) throws Exception {
        userDao.create(entity);
    }

    @Override
    public List<User> read() throws Exception {
        return userDao.read();
    }

    @Override
    public void update(User entity) throws Exception {
        userDao.update(entity);
    }

    @Override
    public void delete(int id) throws Exception {
        userDao.delete(id);
    }

    @Override
    public User getUserByLoginAndPassword(String username, String pass) throws Exception {
        return userDao.getUserByLoginAndPassword(username, pass);
    }

    @Override
    public boolean checkUser(User checkedUser) throws Exception {
        return userDao.checkUser(checkedUser);
    }

    @Override
    public boolean checkUserByUsername(String username) throws Exception {
        return userDao.checkUserByUsername(username);
    }

    @Override
    public ModelAndView login(User user) throws Exception {
        ModelMap modelMap = new ModelMap();
        user = userDao.getUserByLoginAndPassword(user.getUsername(), user.getPassword());
        if (user != null) {
            modelMap.addAttribute(USER, user);
            List<Category> categories = categoryDao.read();
            modelMap.addAttribute(CATEGORIES, categories);
        } else {
            return new ModelAndView(SIGN_IN_PAGE.getPath());
        }
        return new ModelAndView(HOME_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView registration(User user) throws Exception {
        ModelMap modelMap = new ModelMap();
        if (userDao.checkUserByUsername(user.getUsername())) {
            userDao.create(user);
        }
        user = userDao.getUserByLoginAndPassword(user.getUsername(), user.getPassword());
        modelMap.addAttribute(USER, user);
        List<Category> categories = categoryDao.read();
        modelMap.addAttribute(CATEGORIES, categories);
        return new ModelAndView(HOME_PAGE.getPath(), modelMap);
    }

    @Override
    public ModelAndView getUserDataForMyPage(User user) throws Exception {
        ModelMap modelMap = new ModelMap();
        if (user != null && isAuthenticated(user)) {
            Map<Integer, Order> orders = orderDao.getUserOrderById(user.getId());
            modelMap.addAttribute(ORDER_HISTORY, orders);
            return new ModelAndView(MY_PAGE.getPath(), modelMap);
        } else {
            return new ModelAndView(SIGN_IN_PAGE.getPath());
        }

    }
}
