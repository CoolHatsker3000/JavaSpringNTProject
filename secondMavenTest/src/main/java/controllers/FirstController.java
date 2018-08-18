package controllers;


import dao.UserDAO;
import entity.UserEntity;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import services.UserService;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@Controller
public class FirstController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showPage() {
        Map<String, Object> models = new HashMap<String, Object>();
        models.put("user", new User());

        return new ModelAndView("home",models);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String snowPage(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()){

            return "home";
        }
        userService.create(user);
        return "home";
    }
}
