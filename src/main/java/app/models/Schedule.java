package app.models;

import app.daos.BusDao;
import app.daos.RouteDao;

import javax.persistence.*;

@Entity
@Table(name="schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private int price;
    private String date;
    private String departureTime;
    private int bid;
    private int rid;
    public Schedule() {
    }

    public Schedule(int sid,int price, String date,String departureTime, int bid, int rid) {
        this.sid=sid;
        this.price = price;
        this.date = date;
        this.departureTime=departureTime;
        this.bid = bid;
        this.rid = rid;
    }

    public Schedule( int price, String date,String departureTime, int bid, int rid) {
        this.price = price;
        this.date = date;
        this.departureTime=departureTime;
        this.bid = bid;
        this.rid = rid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }
    public Bus getBus() {
        BusDao busDao = new BusDao();
        return busDao.getBusById(this.bid);
    }


    public Route getRoute() {
        RouteDao routeDao = new RouteDao();
        return routeDao.getRouteById(this.rid);
    }
}
