package app.controllers;

import app.daos.AdminDao;
import app.models.Admin;
import app.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    AdminDao dao;

    @GetMapping("/home")
    public String home() {
        return "loginPage/home";
    }


    @GetMapping("/login")
    public ModelAndView adminLogin() {
        return new ModelAndView("loginPage/login", "bean", new Login());
    }
    @PostMapping("/login")
    public String loginProcess(@ModelAttribute("bean") @Validated Login login, BindingResult result, ModelMap model, HttpSession session) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Please fill in the required fields.");
            System.out.println(result);
            return "loginPage/login";
        }

        Admin admin = dao.getLogin(login);

        if (admin == null) {
            model.addAttribute("error", "Invalid email or password!");
            return "loginPage/login";
        }
        if (!login.getEmail().equals(admin.getEmail())) {
            model.addAttribute("error", "Please check your details!");
            return "loginPage/login";
        } else if (!login.getPassword().equals(admin.getPassword())) {
            model.addAttribute("error", "Please check your details!");
            return "loginPage/login";
        }
        session.setAttribute("adminLogin",admin);
        session.setAttribute("adminEmail",admin.getEmail());
        session.setAttribute("password",admin.getPassword());
        return "loginPage/home";
    }
}

