package app.controllers;
import app.daos.BusDao;
import app.models.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BusController {
    @Autowired
    BusDao dao;

    @GetMapping("/bus/buscreate")
    public String createBusGet(){
        return "busPage/busCreate";
    }
    @PostMapping("/bus/buscreate")
    public String createBusPost(@RequestParam String busName){
        Bus bus=new Bus(busName);
        int condition=dao.createBus(bus);
        if(condition==1){
            return "redirect:/bus/busview";
        }
        return "busPage/busCreate";
    }
    @GetMapping("/bus/busview")
    public String busViewGet(Model model){
        List<Bus> buses=dao.getAllBuses();
        model.addAttribute("bus",buses);
        return "busPage/busView";
    }
    @GetMapping("/bus/busedit")
    public String busUpdateGet(){
        return "busPage/busEdit";
    }
    @PostMapping("/bus/busedit")
    public String busUpdatePost(@RequestParam int hbid,String busName){
        Bus bus=new Bus(hbid,busName);
        int condition=dao.updateBus(bus);
        if(condition==1){
            return "redirect:/bus/busview";
        }
        return "busPage/busEdit";
    }
    @GetMapping("/bus/busdelete")
    public String busDelete(@RequestParam int bid){
        int condition=dao.deleteBus(bid);
        if(condition==1){
            return "redirect:/bus/busview";
        }
        return "busPage/busView";
    }
}