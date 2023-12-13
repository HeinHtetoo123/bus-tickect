//package app.controllers;
//
//import app.daos.BusDao;
//import app.daos.RouteDao;
//import app.daos.ScheduleDao;
//import app.models.Schedule;
//import app.models.Search;
//import app.models.StartandEnd;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//import javax.validation.Valid;
//import java.util.List;
//
//@Controller
//public class UserHomepageController {
//    @Autowired
//    ScheduleDao dao;
//    @Autowired
//    BusDao dao1;
//    @Autowired
//    RouteDao dao2;
//    @GetMapping("/searchroute")
//    public ModelAndView adminLogin() {
//        return new ModelAndView("/", "bean", new Search());
//    }
////    @PostMapping("/searchroute")
////    public String loginProcess(@ModelAttribute("bean") @Validated Search search, BindingResult result, ModelMap model, HttpSession session) {
////        if (result.hasErrors()) {
////            model.addAttribute("error", "Please fill in the required fields.");
////            System.out.println(result);
////            return "/";
////        }
////
////        Schedule schedule = dao.getLogin(search);
////
////        if (schedule == null) {
////            model.addAttribute("error", "Invalid email or password!");
////            return "/";
////        }
////        if (search.getRid()!=(schedule.getRid())) {
////            model.addAttribute("error", "Invalid email or password!");
////            return "/";
////        } else if (!search.getDate().equals(search.getDate())) {
////            model.addAttribute("error", "Your password is wrong!");
////            return "/";
////        }
////
////        System.out.println(schedule.getSid());
////        List<Schedule> schedules=dao.getAllSchedulesBysid(schedule.getSid());
////        model.addAttribute("schedule",schedule);
////        return "usersearchseat/busshowpage1";
////    }
//
//    @PostMapping("/searchroute")
//    public String loginProcess(@ModelAttribute("bean") @Valid StartandEnd startandEnd, @Valid Search search, BindingResult result, ModelMap model, HttpSession session, HttpServletRequest request) {
//        if (result.hasErrors()) {
//             return "errorPage"; // Redirect to an error page
//        }
//
//
//        if (!startandEnd.getRid().equals(startandEnd.getEnd())) {
//            model.addAttribute("error", "Invalid start or end locations.");
//
//            return "redirect:/"; // Redirect to an error page
//        }
//
//        Schedule schedule = dao.getLogin(search);
//
//        if (schedule == null) {
//            model.addAttribute("error", "Invalid email or password!");
//            return "redirect:/";
//        }
//        if (search.getRid()!=(schedule.getRid())) {
//            model.addAttribute("error", "Invalid email or password!");
//            return "redirect:/";
//        } else if (!search.getDate().equals(schedule.getDate())) {
//            model.addAttribute("error", "Your password is wrong!");
//            return "redirect:/";
//        }
//
//        List<Schedule> schedules=dao.getScheduleByRid(search);
//        model.addAttribute("schedules",schedules);
//        int  seateno= Integer.parseInt(request.getParameter("seateno"));
//        session.setAttribute("seateno", seateno);
//        return "usersearchseat/busshowpage1";
//    }
//
//
//
//}
package app.controllers;

import app.daos.BusDao;
import app.daos.ScheduleDao;
import app.models.Schedule;
import app.models.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserHomepageController {
    @Autowired
    private ScheduleDao scheduleDao;
    @Autowired
    private BusDao busDao;

    @GetMapping("/searchroute")
    public String userSearch(Model model) {
        model.addAttribute("scheduleShow", new Search());
        return "scheduleShow";
    }

    @PostMapping("/searchroute")
    public String scheduleSearch(
            @ModelAttribute("search") @Validated Search search,
            BindingResult result,
            Model model,
            HttpSession session, HttpServletRequest request
    ) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Please fill in the required fields.");
            return "redirect:/";
        }

        List<Schedule> schedules = scheduleDao.getSchedule(search);
        if (schedules == null || schedules.isEmpty()) {
            model.addAttribute("error", "Invalid date and route!");
            return "error";
        }
        Schedule schedule = schedules.get(0);
        if (!search.getDate().equals(schedule.getDate()) || search.getRid() != schedule.getRid()) {
            model.addAttribute("error", "Invalid date and route!");
            return "error";
        }
        session.setAttribute("schedules", schedules);
        int  seateno= Integer.parseInt(request.getParameter("seateno"));
        session.setAttribute("seateno", seateno);
        return "usersearchseat/busshowpage1";
    }
}
