package app.controllers;

import app.daos.BusDao;
import app.daos.ScheduleDao;
import app.daos.SeatDao;
import app.models.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class SearchRouteController {
    @Autowired
    ScheduleDao dao;
    @Autowired
    BusDao dao1;
    @Autowired
    SeatDao dao2;
//    @GetMapping("/searchroute")
//    public ModelAndView adminLogin() {
//        return new ModelAndView("loginPage/login", "bean", new SeatHp());
//    }
//    @PostMapping("/searchroute")
//    public String loginProcess(@ModelAttribute("bean") @Validated SeatHp seatHp, BindingResult result, ModelMap model, HttpSession session) {
//        if (result.hasErrors()) {
//            model.addAttribute("error", "Please fill in the required fields.");
//            System.out.println(result);
//            return "loginPage/login";
//        }
//
//        Schedule schedule = dao.getScheduleByRid();
//
//        if (schedule == null) {
//            model.addAttribute("error", "Invalid email or password!");
//            return "loginPage/login";
//        }
//        if (seatHp.getRid()!=(schedule.getRid())) {
//            model.addAttribute("error", "Invalid email or password!");
//            return "loginPage/login";
//        } else if (!seatHp.getDate().equals(schedule.getDate())) {
//            model.addAttribute("error", "Your password is wrong!");
//            return "loginPage/login";
//        }
//        session.setAttribute("schedule",schedule);
//        return "usersearchseat/busshowpage1";
//    }
//
//        @GetMapping("/searchroute")
//        public ModelAndView adminLoginGet(@RequestParam int sid , ModelMap model) {
//        List<Seat> seats = dao2.getAllSeats();
//        model.addAttribute("seats", seats);
//        List<Seat> seatd = dao2.getScheduleBySEid(sid);
//        model.addAttribute("seatd", seatd);
//
//        return "usersearchseat/busshowpage1";
//        }
//        @PostMapping("/searchroute")
//        public String loginProcess(@ModelAttribute("bean") @Validated SeatHp seatHp, BindingResult result, ModelMap model, HttpServletRequest request, HttpSession session) {
//            if (result.hasErrors()) {
//                model.addAttribute("error", "Please fill in the required fields.");
//                System.out.println(result);
//                return "redirect:/";
//            }
//
//            Schedule schedule = dao.getSeatSearchHp(seatHp);
//
//            if (schedule == null) {
//                model.addAttribute("error", "Invalid !");
//                return "redirect:/";
//            }
//            if (seatHp.getRid() != (schedule.getRid()) && !seatHp.getDate().equals(schedule.getDate()) && seatHp.getBid()!=(schedule.getBid())) {
//                model.addAttribute("error", "Your data is wrong!");
//                return "redirect:/";
//            }
//            System.out.println(schedule.getSid());
//
//
//            session.setAttribute("schedule",schedule);
//            List<Bus> buses=dao1.getdateByName(schedule);
//            model.addAttribute("buses",buses);
//
//            return "usersearchseat/busshowpage1";
//        }







//    @GetMapping("/seatshowpage")
//    public ModelAndView seatshowpageGet() {
//        return new ModelAndView("redirect:/", "bean", new SeatHp());
//    }

//    @GetMapping("/seatshowpage")
//    public String seatshowpagePost(@ModelAttribute("bean") @Validated SeatHp seatHp, BindingResult result, ModelMap model, HttpServletRequest request) {
//        if (result.hasErrors()) {
//            model.addAttribute("error", "Please fill in the required fields.");
//            System.out.println(result);
//            return "redirect:/";
//        }
//
//        Schedule schedule = dao.getSeatSearchHp(seatHp);
//
//        if (schedule == null) {
//            model.addAttribute("error", "Invalid !");
//            return "redirect:/";
//        }
//        if (seatHp.getRid() != (schedule.getRid()) && !seatHp.getDate().equals(schedule.getDate()) && seatHp.getBid()!=(schedule.getBid())) {
//            model.addAttribute("error", "Your data is wrong!");
//            return "redirect:/";
//        }
//
//
//        int sid=Integer.parseInt(request.getParameter("sid"));
//        List<Seat> seats = dao2.getAllSeats();
//        model.addAttribute("seats", seats);
//        List<Seat> seatd = dao2.getScheduleBySEid(schedule.getSid());
//        model.addAttribute("seatd", seatd);
//
//
//        return "usersearchseat/seatShowPage";
//
//
//    }
@GetMapping("/seathht")
public String listSeats(Model model, HttpServletRequest request) {
    int sid=Integer.parseInt(request.getParameter("sid"));
        List<Seat> seats = dao2.getAllSeats();
        model.addAttribute("seats", seats);
        List<Seat> seatd = dao2.getScheduleBySEid(sid);
        model.addAttribute("seatd", seatd);
    return "usersearchseat/seatShowPage";
}


}
