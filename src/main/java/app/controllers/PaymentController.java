package app.controllers;

import app.daos.PaymentDao;
import app.models.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PaymentController {
    @Autowired
    PaymentDao dao;
    @GetMapping("/pay/create")
    public String payGet(){
        return "paymentPage/paymentCreate";
    }
    @PostMapping("/pay/create")
    public String payPost(@RequestParam String paymentType){
        Payment payment=new Payment(paymentType);
        int condition=dao.createPayment(payment);
        if(condition==1){
            return "redirect:/pay/view";
        }
        return "paymentPage/paymentCreate";
    }
    @GetMapping("/pay/view")
    public String payView(){
        return "paymentPage/paymentView";
    }
    @GetMapping("/pay/delete")
    public String delete(@RequestParam int paid){
        int condition=dao.paymentDelete(paid);
        if(condition==1){
            return "redirect:/pay/view";
        }
        return "paymentPage/paymentView";
    }
    @GetMapping("/transaction/createPage")
    public String transactionPage(){
        return "transactionPage/transaction";
    }
}
