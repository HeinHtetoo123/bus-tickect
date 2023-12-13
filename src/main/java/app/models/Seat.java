package app.models;

import org.springframework.stereotype.Component;

@Component
public class Seat {
    private Integer seid;
    private  String  capacity;


    public Seat(String capacity) {
        this.capacity = capacity;
    }


    public Integer getSeid() {
        return seid;
    }

    public void setSeid(Integer seid) {
        this.seid = seid;
    }

    public Seat() {
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }



    public Seat(int seid, String capacity) {
        this.seid = seid;
        this.capacity = capacity;

    }
}
