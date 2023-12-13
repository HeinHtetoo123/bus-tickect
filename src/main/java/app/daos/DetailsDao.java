package app.daos;

import app.helpers.DBHelper;
import app.models.Details;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class DetailsDao {

    public List<Details> getAllDetails()  {
        List<Details> details=new ArrayList<>();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select * from bookingdetail";
        ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while(rs.next()) {
                Details detail=new Details();
                detail.setBdid(rs.getInt("bdid"));
                detail.setName(rs.getString("name"));
                detail.setEmail(rs.getString("email"));
                detail.setPhone(rs.getString("phone"));
                detail.setTotalPrice(rs.getInt("totalPrice"));
                detail.setSid(rs.getInt("sid"));
                detail.setPaid(rs.getInt("paid"));
                details.add(detail);
            }
        }catch(SQLException e) {
            //System.out.println("Database error");
            e.printStackTrace();
        }
        return details;
    }
    public Details getDetailsById(int bdid){
        Details detail=new Details();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select * from bookingdetail where bdid=?";
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,bdid);
            rs=ps.executeQuery();
            while (rs.next()){
                detail.setBdid(rs.getInt("bdid"));
                detail.setName(rs.getString("name"));
                detail.setEmail(rs.getString("email"));
                detail.setPhone(rs.getString("phone"));
                detail.setSid(rs.getInt("totalPrice"));
                detail.setSid(rs.getInt("sid"));
                detail.setSid(rs.getInt("paid"));
            }
        } catch (SQLException e) {

        }
        return detail;
    }
    public Details getDetailsBySid(int sid){
        Details detail=new Details();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select bdid from bookingdetail where bookingdetail.sid=?;";
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,sid);
            rs=ps.executeQuery();
            while (rs.next()){
                detail.setBdid(rs.getInt("bdid"));
            }
        } catch (SQLException e) {

        }
        return detail;
    }
    public Details getDetailsBy(String  name,String  email,String phone,int totalPrice,int sid,int paid){
        Details detail=new Details();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select * from bookingdetail where name =? and email=? and phone=? and totalPrice=? and sid=? and paid=?";
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,name);
            ps.setString(2,email);
            ps.setString(3,phone);
            ps.setInt(4,totalPrice);
            ps.setInt(5,sid);
            ps.setInt(6,paid);
            rs=ps.executeQuery();
            while (rs.next()){
                detail.setBdid(rs.getInt("bdid"));
                detail.setName(rs.getString("name"));
                detail.setEmail(rs.getString("email"));
                detail.setPhone(rs.getString("phone"));
                detail.setTotalPrice(rs.getInt("totalPrice"));
                detail.setSid(rs.getInt("sid"));
                detail.setPaid(rs.getInt("paid"));

            }
        } catch (SQLException e) {

        }
        return detail;
    }

    public int createDetailspost(Details detail, HttpSession session) {
        int condition = 0;
        Connection con = DBHelper.getInstance().getConnection();
        String query = "insert into bookingdetail (name,email,phone,totalPrice,sid,paid) values (?,?,?,?,?,?)";
        String sql="insert into booking(bdid,seid) values(LAST_INSERT_ID(),?)";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,detail.getName());
            ps.setString(2,detail.getEmail());
            ps.setString(3,detail.getPhone());
            ps.setInt(4,detail.getTotalPrice());
            ps.setInt(5,detail.getSid());
            ps.setInt(6,detail.getPaid());
            condition=ps.executeUpdate();
            String[] selectedSeatIds= (String[]) session.getAttribute("selectedSeatIdsStr");
            for(String seatId:selectedSeatIds){
                int seid = Integer.parseInt(seatId);
                ps=con.prepareStatement(sql);
                ps.setInt(1,seid);
                condition=ps.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;
    }
    public Details getDetailsByTid(int tid){
        Details detail=new Details();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select * from bookingdetail where bdid in(select bdid from Transaction where tid=?);";
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,tid);
            rs=ps.executeQuery();
            while (rs.next()){
                detail.setBdid(rs.getInt("bdid"));
                detail.setName(rs.getString("name"));
                detail.setEmail(rs.getString("email"));
                detail.setPhone(rs.getString("phone"));
                detail.setTotalPrice(rs.getInt("totalPrice"));
                detail.setSid(rs.getInt("sid"));
                detail.setPaid(rs.getInt("paid"));
            }
        } catch (SQLException e) {

        }
        return detail;
    }

}
