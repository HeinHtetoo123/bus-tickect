package app.controllers;

import app.daos.BookingDao;
import app.daos.DetailsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class SeatCreateController {
    @Autowired
    BookingDao dao;
    @Autowired
    DetailsDao dao1;
    @GetMapping("/usersearchseat/seatCreatPage")
    public String seatCreate(){

        return "usersearchseat/seatShowPage";
    }
    @PostMapping("/usersearchseat/seatCreatPage")
    public String seatCreatePost(HttpServletRequest request){
// Get the selected seat IDs
        String[] selectedSeats = request.getParameterValues("selectedSeats");

// Store the selected seat IDs in the session
        HttpSession session = request.getSession();
        session.setAttribute("selectedSeats", selectedSeats);


        return "bookingDetails/details";

    }

    }

