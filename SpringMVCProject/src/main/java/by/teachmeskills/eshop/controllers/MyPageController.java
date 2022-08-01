package by.teachmeskills.eshop.controllers;

import by.teachmeskills.eshop.domain.entities.Order;
import by.teachmeskills.eshop.domain.entities.User;
import by.teachmeskills.eshop.services.IOrderService;
import by.teachmeskills.eshop.services.IUserService;
import by.teachmeskills.eshop.services.impl.OrderServiceImpl;
import by.teachmeskills.eshop.utils.UserAuthenticationUtils;
import lombok.AllArgsConstructor;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import static by.teachmeskills.eshop.utils.EshopConstants.USER;

@RestController
@SessionAttributes({USER})
@RequestMapping("/mypage")
@AllArgsConstructor
public class MyPageController {

    private IUserService userService;

    @GetMapping("/open")
    public ModelAndView openMyPage(@ModelAttribute(USER) User user) throws Exception {
        return userService.getUserDataForMyPage(user);
    }
}
