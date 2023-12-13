package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CountactController {
@GetMapping("/thankyou")
    public String thankYouPage(){
    return "contactPage/thankYouPage";
}



}
