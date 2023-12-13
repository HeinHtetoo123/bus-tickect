package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {
    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("adminLogin");
        session.removeAttribute("adminEmail");
        session.removeAttribute("password");
        session.invalidate();
        return "redirect:/";

    }
}

