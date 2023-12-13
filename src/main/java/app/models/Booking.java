package app.models;

import org.springframework.stereotype.Component;

@Component
public class Booking {
    public int getBookingid() {
        return bookingid;
    }

    public void setBookingid(int bookingid) {
        this.bookingid = bookingid;
    }

    public Booking() {
    }

    public int getBdid() {
        return bdid;
    }

    public void setBdid(int bdid) {
        this.bdid = bdid;
    }

    public int getSeid() {
        return seid;
    }

    public void setSeid(int seid) {
        this.seid = seid;
    }

    private int bookingid, bdid,seid;

    public Booking(int bookingid, int bdid, int seid) {
        this.bookingid = bookingid;
        this.bdid = bdid;
        this.seid = seid;
    }

    public Booking(int bdid, int seid) {
        this.bdid = bdid;
        this.seid = seid;
    }
}
