package app.models;

import app.daos.RouteDao;
import org.springframework.stereotype.Controller;

@Controller
public class Search {
    private int rid;


    public Search() {
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public Search(int rid, String date) {
        this.rid = rid;
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }



    private String date;
    public Route getRoute() {
        RouteDao routeDao = new RouteDao();
        return routeDao.getRouteById(this.rid);
    }
}
