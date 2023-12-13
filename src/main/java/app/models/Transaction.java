package app.models;
import org.springframework.stereotype.Component;
@Component
public class Transaction {
    private int tid;
    private String transactionNo;
    private String payName;
    private String payPhone;
    private int amount;
    private int bdid;




    public Transaction() {
    }

    public Transaction(int tid, String transactionNo, String payName, String payPhone, int amount ,int bdid) {
        this.tid = tid;
        this.transactionNo = transactionNo;
        this.payName = payName;
        this.payPhone = payPhone;
        this.amount = amount;
        this.bdid = bdid;

    }

    public Transaction(String transactionNo, String payName, String payPhone, int amount,int bdid) {
        this.transactionNo = transactionNo;
        this.payName = payName;
        this.payPhone = payPhone;
        this.amount = amount;
        this.bdid = bdid;

    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getPayPhone() {
        return payPhone;
    }

    public void setPayPhone(String payPhone) {
        this.payPhone = payPhone;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
    public int getBdid() {
        return bdid;
    }

    public void setBdid(int bdid) {
        this.bdid = bdid;
    }
}
