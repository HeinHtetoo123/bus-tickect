package app.models;

import org.springframework.stereotype.Component;

@Component
public class Payment {
    private int paid;

    public Payment() {
    }

    public int getPaid() {
        return paid;
    }

    public Payment(String paymentType) {
        this.paymentType = paymentType;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Payment(int paid, String paymentType) {
        this.paid = paid;
        this.paymentType = paymentType;
    }

    private String paymentType;
}
