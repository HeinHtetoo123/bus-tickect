package app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class EnterOtpController {

    @GetMapping("/EnterOtp")
    public String Otp(HttpSession session, Model model) {
        // Retrieve email from the session
        String email = (String) session.getAttribute("email");
        model.addAttribute("email", email); // Set the 'email' as a model attribute
        return "forgectPage/EnterOtp";
    }

    @PostMapping("/EnterOtp")
    public String validateOtp(
            @RequestParam("otp") String otp,
            HttpSession session,
            RedirectAttributes redirectAttributes,
            Model model) {

        // Retrieve the email from the session
        String email = (String) session.getAttribute("email");

        int value = Integer.parseInt(otp);
        int storedOtp = (int) session.getAttribute("otp");

        if (value == storedOtp) {
            session.setAttribute("email", email);
            model.addAttribute("email", email); // Set the 'email' as a model attribute
            System.out.println(email+"jjjjj");
            session.setAttribute("email", email);
            return "redirect:/newPassword"; // View name for success case
        } else {
            model.addAttribute("message", "wrong otp");
            return "redirect:/EnterOtp"; // Specify the view name for incorrect OTP case
        }
    }
}