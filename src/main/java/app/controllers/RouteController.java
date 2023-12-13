package app.controllers;
import app.daos.RouteDao;
import app.models.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class RouteController {
    @Autowired
    RouteDao dao;
    @GetMapping("/route/routecreate")
    public String routeCreateGet(){
        return "busPage/routeCreate";
    }
    @PostMapping("/route/routecreate")
    public String routeCreatePost(@RequestParam String start,String end){
        Route rou=new Route(start,end);
        int condition=dao.createRoute(rou);
        if(condition==1){
            return "redirect:/route/routeview";
        }
        return "busPage/routeCreate";
    }
    @GetMapping("/route/routeview")
    public String routeView(Model model){
        List<Route> routes=dao.getAllRoutes();
        model.addAttribute("route",routes);
        return "busPage/routeView";
    }
    @GetMapping("/route/routeedit")
    public String routeUpdateGet(){
        return "busPage/routeEdit";
    }
    @PostMapping("/route/routeedit")
    public String routeUpdatePost(@RequestParam int hrid,String start,String end){
        Route rou=new Route(hrid,start,end);
        int condition=dao.updateRoute(rou);
        if(condition==1){
            return "redirect:/route/routeview";
        }
        return "busPage/routeEdit";
    }
    @GetMapping("/route/routedelete")
    public String routeDelete(@RequestParam int rid,Model model){
        int condition=dao.deleteRoute(rid);
        if(condition==1){
            return "redirect:/route/routeview";
        }
        model.addAttribute("error","This route is already booked!");
        return "redirect:/route/routeview";
    }
}
