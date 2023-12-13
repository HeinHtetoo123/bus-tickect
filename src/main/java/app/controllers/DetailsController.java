//package app.controllers;
//
//
//import app.daos.DetailsDao;
//import app.models.Details;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.http.HttpSession;
//
//@Controller
//public class DetailsController {
//    @Autowired
//    DetailsDao dao;
//    @GetMapping("/details/create")
//    public String create(){
//
//        return "bookingDetails/details";
//    }
//
//    @PostMapping("/details/create")
//    public String createPost(@RequestParam String name, String email, String phone,int totalPrice, int sid, int paid, Model model, HttpSession session) {
//        Details details = new Details(name, email, phone,totalPrice, sid, paid);
//        int condition = dao.createDetailspost(details, session);
//        if(condition == 1) {
//            Details details1 = dao.getDetailsBy(name, email, phone, totalPrice, sid, paid);
//
//           if (paid==1){
//               return "paymentPage/kpay";
//           }
//            return "paymentPage/wavePay";
//        }
//
//
//        return "bookingDetails/details";
//
//    }
//    @GetMapping("/details/view")
//    public String view(){
//        return "bookingDetails/detailsView";
//    }
//}
package app.controllers;
import app.daos.DetailsDao;
import app.daos.SeatDao;
import app.models.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class DetailsController {
    @Autowired
    DetailsDao detailsDao;
    @Autowired
    SeatDao seatDao;
    @GetMapping("/details/create")
    public String create() {
        return "bookingDetails/details";
    }

    @PostMapping("/details/create")
    public String createPost(@RequestParam String name, String email, String phone,int totalPrice, int sid, int paid, Model model, HttpSession session) {
        Details details = new Details(name, email, phone,totalPrice, sid, paid);
        int condition = detailsDao.createDetailspost(details, session);
        if (condition == 1) {
            Details details1=detailsDao.getDetailsBy(name,email,phone,totalPrice,sid,paid);
            session.setAttribute("name",name);
            session.setAttribute("email",email);
            session.setAttribute("phone",phone);
            session.setAttribute("totalPrice",totalPrice);
            session.setAttribute("sid",sid);
            session.setAttribute("paid",paid);
            System.out.println(details1.getBdid()+"xdcfvghj");
            if (details1.getPayment().getPaymentType().equals("Wavepay")){
                return "paymentPage/wavePay";
            }
            if (details1.getPayment().getPaymentType().equals("Kpay")){
                return "paymentPage/kpay";
            }
            return "transactionPage/transaction";
        }
        return "redirect:/details/create";
    }
    @GetMapping("/details/view")
    public String view(HttpServletRequest request,HttpSession session){
        return "bookingDetails/detailsView";
    }
}
