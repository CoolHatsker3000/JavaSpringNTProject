package controllers;


import models.TariffAttr;
import models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import services.TariffAttrsService;
import services.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class FirstController {
    @Autowired
    private UserService userService;
    @RequestMapping(method = RequestMethod.GET)
    public String showStartPage(@CookieValue(name = "currentUserId", defaultValue = "none") String userId, Model model) {

        if (!userId.equals("none") && !userId.equals("")) {
            return "redirect:/user";
        }
        model.addAttribute("user", new User());
        return "home";
    }

    @RequestMapping(value = "/logout")
    public String logOut(HttpServletRequest request, HttpServletResponse response, Model model) {
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("currentUserId")) {
                cookie.setValue("");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String getRegisterPage(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("message","Enter your phone number and your password");
        return "register";
    }
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public String registerUser( @Valid @ModelAttribute("user") User user,BindingResult result, HttpServletResponse response, Model model){
        if (result.hasErrors()){
            model.addAttribute("message","Try again");
            return "register";
        }
        User possibleUser=userService.getById(user);
        if (possibleUser.getUserId()!=null){
            if (user.getUserPassword().equals(possibleUser.getUserPassword())){
                model.addAttribute("user",user);
                return "redirect:/user";
            }else{
                model.addAttribute("message","User with this phone number exists");
                return "register";
            }
        } else{
            user.setUserBalance("0.0");
            userService.create(user);
            response.addCookie(new Cookie("currentUserId",user.getUserId()));
            model.addAttribute("user",user);
            return "redirect:/user";
        }
    }



}
