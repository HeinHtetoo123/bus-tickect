package app.models;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rid;
    @NotEmpty
    private  String start;
    @NotEmpty
    private String end;

    public Route() {
    }

    public Route(int rid,String start, String end) {
        this.rid = rid;
        this.start = start;
        this.end = end;
    }

    public Route(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
