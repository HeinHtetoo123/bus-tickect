package app.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class NewPasswordController {

    @GetMapping("/newPassword")
    public String newPassword(HttpSession session) {
        // Retrieve email from the session
        String email = (String) session.getAttribute("email");
        if (email == null || email.isEmpty()) {
            // Handle the case where email is missing or empty
            return "redirect:/forgotPassword"; // Redirect to the forgot password page or appropriate error page
        }
        return "forgectPage/newPassword";
    }
    @PostMapping("/newPassword")
    public String resetPassword(
            @RequestParam String password,
            @RequestParam String confPassword,
            RedirectAttributes redirectAttributes,
            HttpSession session) {
        String email = (String) session.getAttribute("email");

        if (password != null && confPassword != null && password.equals(confPassword) && email != null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/busticket", "root", "rootroot");
                PreparedStatement ps = con.prepareStatement("UPDATE admin SET password = ? WHERE email = ?");
                ps.setString(1, password);
                ps.setString(2, email);
                int rowCount = ps.executeUpdate();
                if (rowCount > 0) {
                    redirectAttributes.addFlashAttribute("status", "resetSuccess");
                } else {
                    redirectAttributes.addFlashAttribute("status", "resetFailed");
                }
                return "redirect:/login";
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace(); // Log or handle the exception appropriately
            }
        }
        return "redirect:/kdhieji";
    }





}