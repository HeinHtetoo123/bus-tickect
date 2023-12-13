package app.models;

import app.daos.*;

import javax.persistence.*;

@Entity
@Table(name="details")
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bdid;
    private String name;
    private String email;
    private String phone;
    private int sid;
    private int bid;
    private int rid;
    private int paid;
    private int seid;
    private int totalPrice;

    public Details() {
    }

    public Details(int bdid,String name, String email, String phone,int totalPrice, int sid,int paid) {
        this.bdid=bdid;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.totalPrice = totalPrice;
        this.sid = sid;
        this.paid = paid;
    }

    public Details(String name, String email, String phone,int totalPrice,int sid,int paid) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.totalPrice = totalPrice;
        this.sid = sid;
        this.paid = paid;
    }

    public int getBdid() {
        return bdid;
    }

    public void setBdid(int bdid) {
        this.bdid = bdid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }
    public int getPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }
    public Schedule getSchedule() {
        ScheduleDao scheduleDao = new ScheduleDao();
        return scheduleDao.getScheduleById(this.sid);
    }
    public Bus getBus() {
        BusDao busDao = new BusDao();
        return busDao.getBusById(this.bid);
    }


    public Route getRoute() {
        RouteDao routeDao = new RouteDao();
        return routeDao.getRouteById(this.rid);
    }



    public Seat getSeat() {
        SeatDao seatDao = new SeatDao();
        return seatDao.getSeatsById(this.seid);
    }
    public Payment getPayment() {
        PaymentDao paymentDao = new PaymentDao();
        return paymentDao.getPaymentById(this.paid);
    }
}
