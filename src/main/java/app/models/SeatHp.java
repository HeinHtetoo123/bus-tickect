package app.models;

public class SeatHp {
    private int bid,rid;
   private String date;

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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SeatHp() {
    }

    public SeatHp(int bid, int rid, String date) {
        this.bid = bid;
        this.rid = rid;
        this.date = date;
    }
}
