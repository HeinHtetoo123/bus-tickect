package app.controllers;

import app.daos.DetailsDao;
import app.daos.TransactionDao;
import app.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TransactionController {
    @Autowired
    TransactionDao dao;
    @Autowired
    DetailsDao doa1;
    @GetMapping("/transaction/create")
    public String create(){
        return "transactionPage/transaction";
    }
    @PostMapping("/transaction/create")
    public String createPost(@RequestParam String transactionNo,String payName,String payPhone,int amount,int bdid){
        Transaction transaction=new Transaction(transactionNo,payName,payPhone,amount,bdid);
        int condition=dao.createTransaction(transaction);
        if(condition==1){
            return "contactPage/thankYouPage";
        }
        return "transactionPage/transaction";
    }
    @GetMapping("/transaction/view")
    public String view(){
        return "transactionPage/transactionView";
    }
    @GetMapping("/transaction/delete")
    public String delete(@RequestParam int tid){
        int condition=dao.deleteTransaction(tid);
        if(condition==1){
            return "transactionPage/transactionView";
        }
        return "transactionPage/transactionView";
    }

    @GetMapping("/transaction/print")
    public String print() {
        return "transactionPage/ticket";
    }

    @PostMapping("/transaction/print")
    public String printPost() {

        return "transactionPage/ticket";

    }

}
