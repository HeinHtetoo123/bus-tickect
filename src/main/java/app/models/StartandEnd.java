package app.models;

public class StartandEnd {
  private String rid,end;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public StartandEnd() {
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public StartandEnd(String rid, String end) {
        this.rid = rid;
        this.end = end;
    }
}
