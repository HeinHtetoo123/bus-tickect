package app.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name="bus")
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;



    @NotEmpty
    private String busName;

    public Bus() {
    }

    public Bus(int bid,  String busName) {
        this.bid = bid;
        this.busName = busName;
    }

    public Bus( String busName) {

        this.busName = busName;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }


    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }
}
