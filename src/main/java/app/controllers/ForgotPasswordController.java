package app.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import java.util.Properties;
import java.util.Random;

@Controller
public class ForgotPasswordController {

    @GetMapping("/forgotPassword")
    public String forgot() {
        return "forgectPage/forgectpassword";
    }

    @PostMapping("/forgotPassword")
    public String sendEmail(@RequestParam("email") String email, Model model, HttpSession session, RedirectAttributes redirectAttributes) throws MessagingException {
        if (email != null && !email.isEmpty()) {
            // Sending OTP
            Random rand = new Random();
            int otpValue = rand.nextInt(1255650);

            String to = email; // Change accordingly
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session mailSession = Session.getDefaultInstance(props, new Authenticator() {
                public PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("busmanagementteam38@gmail.com", "ngwb vwhw nulr jbpn"); // Put your email and password here
                }
            });


            // Compose the email message
            MimeMessage message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(email)); // Change accordingly
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Hello");
            message.setText("Your OTP is: " + otpValue);

            // Send the email
            Transport.send(message);
            System.out.println("Message sent successfully");

            model.addAttribute("message", "OTP is sent to your email id");
            session.setAttribute("otp", otpValue);
            session.setAttribute("email", email);
            System.out.println(email+"hhhh");

            return "redirect:/EnterOtp"; // Specify the view name
        } else {
            // Handle the case when email is missing or empty
            redirectAttributes.addFlashAttribute("error", "Email is required");
            return "redirect:/forgotPassword"; // Specify an error view
        }
    }
}