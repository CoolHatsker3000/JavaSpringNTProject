package controllers;

import models.Tariff;
import models.User;
import models.UserTariff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import services.TariffAttrsAndInfoService;
import services.TariffService;
import services.UserService;
import services.UserTariffService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserPageController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserTariffService userTariffService;
    @Autowired
    private TariffService tariffService;
    @Autowired
    private TariffAttrsAndInfoService tariffAttrsAndInfoService;

    @RequestMapping(method = RequestMethod.POST)
    public String UserPage(@Valid @ModelAttribute("user") User user,
                           BindingResult result,
                           Model model, HttpServletRequest request,
                           HttpServletResponse response) {
        if (result.hasErrors()) {
            return "home";
        }
        User currentUser = userService.getById(user);
        if (currentUser.getUserId() == null || !currentUser.getUserPassword().equals(user.getUserPassword())) {
            model.addAttribute("user", new User());
            model.addAttribute("message", "User with this number don't found, try again or register now");
            return "register";
        } else {
            model.addAttribute("user", currentUser);
            UserTariff userTariff = userTariffService.getById(Long.parseLong(currentUser.getUserId()));
            if (request.getCookies().length > 1) {
                Cookie cookie = request.getCookies()[1];
                cookie.setValue(currentUser.getUserId());
                response.addCookie(cookie);
            } else response.addCookie(new Cookie("currentUserId", currentUser.getUserId()));
            if (userTariff.getTariffID() == null) {
                model.addAttribute("tariff", null);
                return "user_page"; //new ModelAndView("user_page",models);
            }
            Tariff tariff = tariffService.getById(Long.parseLong(userTariff.getTariffID()));
            model.addAttribute("tariff", tariff);
            Map<String, String> attrs = tariffAttrsAndInfoService.getAttrInfo(Integer.parseInt(userTariff.getTariffID()));
            model.addAttribute("attrs", attrs);
            return "user_page";
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getUserPage(@CookieValue(value = "currentUserId", defaultValue = "none") String userId, Model model) {
        if (userId.equals("none")) return "redirect:/";
        User currentUser = userService.getById(Long.parseLong(userId));
        model.addAttribute("user", currentUser);
        UserTariff userTariff = userTariffService.getById(Long.parseLong(currentUser.getUserId()));
        if (userTariff.getTariffID() == null) {
            model.addAttribute("tariff", null);
            return "user_page"; //new ModelAndView("user_page",models);
        }
        model.addAttribute("tariff", tariffService.getById(Long.parseLong(userTariff.getTariffID())));
        model.addAttribute("attrs",
                tariffAttrsAndInfoService.getAttrInfo(Integer.parseInt(userTariff.getTariffID())));
        return "user_page";
    }

    @RequestMapping(params = {"tariffID"}, method = RequestMethod.POST)
    public String changeTariff(@CookieValue("currentUserId") String userId,
                               @ModelAttribute("userTariff") UserTariff userTariff) {
        userTariff.setUserID(userId);
        UserTariff currentTariff = userTariffService.getById(userTariff);
        if (currentTariff.getTariffID() == null) {
            userTariffService.create(userTariff);
        } else
            userTariffService.update(userTariff);
        return "redirect:/user";
    }


}
