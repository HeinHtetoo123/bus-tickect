package app.controllers;

import app.daos.BusDao;
import app.daos.ScheduleDao;
import app.models.Bus;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ScheduleCreateController {
    @Autowired
    ScheduleDao dao;
    @Autowired
    BusDao dao1;
    @GetMapping("/schedule/schedulecreate1")
    public ModelAndView adminLogin() {
        return new ModelAndView("scheduleCreatePage/schedulecreate", "bean", new Search());
    }
    @PostMapping("/schedule/schedulecreate1")
    public String scheduleSearch(@ModelAttribute("bean") @Validated Search search, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            model.addAttribute("error", "Please fill in the required fields.");
            return "redirect:/schedule/schedulecreate1";
        }

        Schedule schedule = dao.getLogin(search);

        if (schedule == null) {
            model.addAttribute("error", "Invalid has error");
            return "schedulePage/scheduleCreate";
        }
        if (search.getDate().equals(schedule.getDate()) && search.getRid()==(schedule.getRid())) {
            model.addAttribute("error", "Invalid date and route!");
            session.setAttribute("search",search);
            session.setAttribute("start",search.getRoute().getStart());
            session.setAttribute("end",search.getRoute().getEnd());
            session.setAttribute("date",search.getDate());
            List<Bus> buses=dao1.getBusId(schedule);
            model.addAttribute("buses",buses);
            return "scheduleCreatePage/schedulecreate2";
        }
        session.setAttribute("search",search);
        model.addAttribute("star",search.getRoute().getStart());
        model.addAttribute("en",search.getRoute().getEnd());
        model.addAttribute("dat",search.getDate());
        return "schedulePage/scheduleCreate";
    }
//
//    public String loginProcess(@ModelAttribute("bean") @Validated Search search, BindingResult result, ModelMap model, HttpSession session) {
//        if (result.hasErrors()) {
//            model.addAttribute("error", "Please fill in the required fields.");
//            System.out.println(result);
//            return "redirect:/schedule/nextsearch";
//        }
//
//        Schedule schedule = dao.getLogin(search);
//
//        if (schedule == null) {
//            model.addAttribute("error", "Invalid email or password!");
//            return "redirect:/schedule/nextsearch";
//        }
//        if  (search.getRid()!=(schedule.getRid()) && !search.getDate().equals(schedule.getDate())) {
//            model.addAttribute("error", "Your password is wrong!");
//            return "redirect:/schedule/nextsearch";
//        }
//
//        session.setAttribute("schedule",schedule);
//        List<Bus> buses=dao1.getBusId(schedule);
//        model.addAttribute("buses",buses);
//
//        return "scheduleCreatePage/schedulecreate2";
//
//    }


    @GetMapping("/scheduleCreatePage/schedulecreate")
    public String scheduleCreatePage(){
        return "/scheduleCreatePage/schedulecreate";
    }


}
