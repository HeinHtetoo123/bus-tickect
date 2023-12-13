package app.daos;

import app.helpers.DBHelper;
import app.models.Transaction;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionDao {
    public int createTransaction(Transaction transaction) {
        int condition = 0;
        Connection con = DBHelper.getInstance().getConnection();
        String query = "INSERT INTO transaction (transactionNo,name,phone,amount,bdid) VALUES (?,?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1,transaction.getTransactionNo());
            ps.setString(2, transaction.getPayName());
            ps.setString(3, transaction.getPayPhone());
            ps.setInt(4, transaction.getAmount());
            ps.setInt(5, transaction.getBdid());

            condition = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return condition;
    }
    public List<Transaction> getAllTransactions()  {
        List<Transaction> transactions=new ArrayList<>();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select * from transaction ";
        ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                Transaction transaction=new Transaction();
                transaction.setTid(rs.getInt("tid"));
                transaction.setTransactionNo(rs.getString("transactionNo"));
                transaction.setPayName(rs.getString("name"));
                transaction.setPayPhone(rs.getString("phone"));
                transaction.setAmount(rs.getInt("amount"));
                transaction.setBdid(rs.getInt("bdid"));
                transactions.add(transaction);
            }
        }catch(SQLException e) {

            e.printStackTrace();
        }
        return transactions;
    }
    public int deleteTransaction(int tid){
        int condition=0;
        Connection con=DBHelper.getInstance().getConnection();
        String query="delete from transaction where tid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,tid);
            condition=ps.executeUpdate();
        } catch (SQLException e) {

        }
        return condition;
    }
}
