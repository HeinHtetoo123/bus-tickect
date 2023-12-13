package app.daos;
import app.helpers.DBHelper;
import app.models.Payment;
import org.springframework.stereotype.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentDao {
    public int createPayment(Payment payment){
        int condition=0;
        Connection con=DBHelper.getInstance().getConnection();
        String query="insert into payment (paid,paymentType) values (?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,payment.getPaid());
            ps.setString(2,payment.getPaymentType());
            condition=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;

    }
    public List<Payment> getAllPayment()  {
        List<Payment> payments=new ArrayList<>();
        Connection con= DBHelper.getInstance().getConnection();
        String query="select * from payment";
        ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                Payment payment=new Payment();
                payment.setPaid(rs.getInt("paid"));
                payment.setPaymentType(rs.getString("paymentType"));

                payments.add(payment);
            }
        }catch(SQLException e) {
            //System.out.println("Database error");
            e.printStackTrace();
        }
        return payments;
    }
    public Payment getPaymentById(int paid){
        Payment payment=new Payment();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select * from payment where paid=?";
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,paid);
            rs=ps.executeQuery();
            while (rs.next()){
                payment.setPaid(rs.getInt("paid"));
                payment.setPaymentType(rs.getString("paymentType"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }
    public int paymentDelete(int paid){
        int condition=0;
        Connection con=DBHelper.getInstance().getConnection();
        String query="delete from payment where paid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,paid);
            condition=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;
    }
}
