package app.daos;

import app.helpers.DBHelper;
import app.models.Seat;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SeatDao {
public List<Seat> getScheduleBySEid(int sid){
    List<Seat> seats=new ArrayList<>();
    Connection con= DBHelper.getInstance().getConnection();
    ResultSet rs;
//    String query="select * from buse where buse.bid=(select bid from bus where bus.bid=?);";
    String query="select * from seat where seat.seid  in(  select booking.seid from booking where booking.bdid   in (select bdid from bookingdetail where bookingdetail.sid=?));";
//    String query="select * from seat where seat.seid not in(select booking.seid from booking where booking.bdid in (select bookingdetail.bdid from bookingdetail where bookingdetail.sid in (select schedule.sid from schedule where date=? and bid=? and rid=?)));";
   // String query="select * from seat where seat.seid not in(  select booking.seid from booking where booking.bdid   in (select bdid from bookingdetail where bookingdetail.sid in (select schedule.sid from schedule where rid=? and date=? and bid=?)));";
    try {
        PreparedStatement ps=con.prepareStatement(query);
        ps.setInt(1,sid);

        rs=ps.executeQuery();
        while (rs.next()){
            Seat seat=new Seat();
            seat.setSeid(rs.getInt("seid"));
            seat.setCapacity(rs.getString("capacity"));
            seats.add(seat);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return seats;
}
    public List<Seat> getAllSeats(){
        List<Seat> seats=new ArrayList<>();
        ResultSet rs;
        Connection con= DBHelper.getInstance().getConnection();
        String query="SELECT * FROM seat";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()){
                Seat seat=new Seat();
                seat.setSeid(rs.getInt("seid"));
                seat.setCapacity(rs.getString("capacity"));
                seats.add(seat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seats;

    }
    public Seat getSeatsById(int seid) {
        Seat seat=new Seat();
        ResultSet rs;
        Connection con= DBHelper.getInstance().getConnection();
        String query="SELECT * FROM seat WHERE seid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,seid );
            rs=ps.executeQuery();
            while (rs.next()) {
                seat.setSeid(rs.getInt("seid"));
                seat.setCapacity(rs.getString("capacity"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return seat;
    }
}
