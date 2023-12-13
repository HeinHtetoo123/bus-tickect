package app.models;

import javax.persistence.*;

@Entity
@Table(name = "buse")
public class Buse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private int buseid;
private int bid;
private int seid;

    public int getBuseid() {
        return buseid;
    }

    public void setBuseid(int buseid) {
        this.buseid = buseid;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getSeid() {
        return seid;
    }

    public void setSeid(int seid) {
        this.seid = seid;
    }

    public Buse() {
    }

    public Buse(int bid, int seid) {
        this.bid = bid;
        this.seid = seid;
    }
}

