package app.controllers;

import app.daos.AdminDao;
import app.models.Admin;
import app.models.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {
    @Autowired
    AdminDao dao;
    @RequestMapping(value = "/admin/admincreate", method = RequestMethod.GET)
    public String userCreateGet() {
        System.out.println("Get Method");

        return "loginPage/adminCreate";
    }
    @PostMapping("/admin/admincreate")
    public String adminCreate(Model model, @RequestParam String name,String email,String password)
    {   Admin admin=new Admin(name,email,password);
        int condition=dao.createAdmin(admin);
        if(condition==1){
            return "loginPage/adminView";
        }
        return "loginPage/adminCreate";
    }

    @GetMapping("/adminview")
    public String view(Model model, HttpServletRequest request, HttpSession session){
        String email = (String) session.getAttribute("email");
        String password = (String) session.getAttribute("password");
        AdminDao dao = new AdminDao();
        Login login = new Login(email, password);
        Admin admin = dao.getLogin(login);
        model.addAttribute("admin", admin);
        return "loginPage/adminView";
    }
    @GetMapping("/admindelete")
    public String delete(@RequestParam int id,Model model){
        int condition=dao.deleteAdmin(id);
        if(condition==1){
            return "loginPage/adminView";
        }
        return "loginPage/adminView";
    }
    @GetMapping("/adminedit")
    public String update(){
        return "loginPage/adminEdit";
    }
    @PostMapping("/adminedit")
    public String edit(@RequestParam int hid,String name,String email,String password,Model model){
        Admin admin=new Admin(hid,name,email,password);
        int condition=dao.updateAdmin(admin);
        if(condition==1){
            return "loginPage/adminView";
        }
        return "loginPage/adminEdit";
    }
}
