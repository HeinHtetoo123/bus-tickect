package app.controllers;
import app.daos.ScheduleDao;
import app.models.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@Controller
public class ScheduleController {
    @Autowired
    ScheduleDao dao;

    @RequestMapping(value = "/schedule/create", method = RequestMethod.GET)
    public String scheduleCreateGet(Model model) {
        System.out.println("Get Method");
        return "schedulePage/scheduleCreate";
    }
    @PostMapping("/schedule/create")
    public String scheduleCreate(Model model, @RequestParam int price, String date,String departureTime, int bid, int rid) throws ParseException {
        Schedule schedule=new Schedule(price,date,departureTime,bid,rid);
        int condition=dao.createSchedule(schedule);
        if(condition==1){
            return "redirect:/schedule/view";
        }
        return "schedulePage/scheduleCreate";
    }
    @GetMapping("/schedule/view")
    public String view(Model model){
        List<Schedule> schedule=dao.getAllSchedules();
        model.addAttribute("schedule",schedule);
        return "schedulePage/scheduleView";

    }
    @GetMapping("/schedule/delete")
    public String delete(Model model,@RequestParam int sid){
        int condition=dao.deleteSchedule(sid);
        if(condition==1){
            return "redirect:/schedule/view";
        }
        return "schedulePage/scheduleView";
    }
    @GetMapping("/schedule/edit")
    public String routeUpdateGet(){
        return "schedulePage/scheduleEdit";
    }
    @PostMapping("/schedule/edit")
    public String scheduleUpdatePost(@RequestParam int hsid,int price,String date,String departureTime,int bid,int rid){
        Schedule schedule=new Schedule(hsid,price,date,departureTime,bid,rid);
        int condition=dao.updateSchedule(schedule);
        if(condition==1){
            return "redirect:/schedule/view";
        }
        return "schedulePage/scheduleEdit";
    }

//    @RequestMapping(value = "/schedule/update", method = RequestMethod.GET)
//    public String scheduleUpdateGetPage(Model model) {
//        System.out.println("Get Method");
//        return "schedulePage/scheduleUpdate";
//    }
//    @PostMapping("/schedule/update")
//    public String scheduleUpdatePage(Model model, @RequestParam String scheduleId, int price, String date, int bid, int rid) throws ParseException {
//        Schedule schedule=new Schedule(scheduleId,price,date,bid,rid);
//        int condition=dao.createSchedule(schedule);
//        if(condition==1){
//            return "redirect:/schedule/view";
//        }
//        return "schedulePage/scheduleUpdate";
//    }

    @GetMapping("/date/search")
    public String getSearch(){
        System.out.println("Get ");
        return "schedulePage/scheduleView";
    }
    @PostMapping ("/date/search")
    public String search(@RequestParam  String date,Model model){
        List<Schedule> schedule=dao.search(date);
        if (schedule != null) {
            model.addAttribute("schedules",schedule);
            model.addAttribute("date",date);
            return "schedulePage/scheduleView";
        }
        else {
            return "schedulePage/scheduleCreate";
        }
    }
}

