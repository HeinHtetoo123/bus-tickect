package app.daos;

import app.helpers.DBHelper;
import app.models.Bus;
import app.models.Schedule;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BusDao {
    public int createBus(Bus bus){
        int condition=0;
        Connection con= DBHelper.getInstance().getConnection();
        String query="INSERT INTO bus (busName) VALUES (?)";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,bus.getBusName());
            condition=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;
    }

    public List<Bus> getAllBuses(){
        List<Bus> buses=new ArrayList<>();
        ResultSet rs;
        Connection con= DBHelper.getInstance().getConnection();
        String query="SELECT * FROM bus";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()){
                Bus bus=new Bus();
                bus.setBid(rs.getInt("bid"));
                bus.setBusName(rs.getString("busName"));
                buses.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buses;

    }
    public Bus getBusById(int bid){
        Bus bus=new Bus();
        ResultSet rs;
        Connection con= DBHelper.getInstance().getConnection();
        String query="SELECT * FROM bus WHERE bid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,bid);
            rs=ps.executeQuery();
            while (rs.next()){
                bus.setBid(rs.getInt("bid"));
                bus.setBusName(rs.getString("busName"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bus;
    }
    public int updateBus(Bus bus){
        int condition=0;
        Connection con= DBHelper.getInstance().getConnection();
        String query="UPDATE bus SET busName=? WHERE bid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,bus.getBusName());
            ps.setInt(2,bus.getBid());
            condition=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;
    }
    public int deleteBus(int bid){
        int condition=0;
        Connection con= DBHelper.getInstance().getConnection();
        String query="DELETE FROM bus WHERE bid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,bid);
            condition=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;
    }

//    public List<Bus> getAllBusBid(Schedule schedule){
//        List<Bus> buses=new ArrayList<>();
//        ResultSet rs;
//        Connection con= DBHelper.getInstance().getConnection();
//        String query="SELECT bus.bid,bus.busId, bus.busName FROM bus INNER JOIN schedule ON bus.bid = schedule.bid INNER JOIN route ON schedule.rid = route.rid WHERE schedule.date =? AND schedule.rid != ?";
//        try {
//            PreparedStatement ps=con.prepareStatement(query);
//            ps.setString(1, schedule.getDate());
//            ps.setInt(2, schedule.getRid());
//
//            rs=ps.executeQuery();
//            while (rs.next()){
//                Bus bus=new Bus();
//                bus.setBid(rs.getInt("bid"));
////                bus.setBusId(rs.getString("busId"));
//                bus.setBusName(rs.getString("busName"));
//                buses.add(bus);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return buses;
//
//    }
public List<Bus> getBusId(Schedule schedule){
    List<Bus> buses=new ArrayList<>();
    Connection con=DBHelper.getInstance().getConnection();
    ResultSet rs;
    String query="SELECT bus.bid,  bus.busName FROM bus where bus.bid not in (select schedule.bid from schedule where schedule.date = ? and schedule.rid = ?)";
    try {
        PreparedStatement ps=con.prepareStatement(query);
        ps.setString(1,schedule.getDate());
        ps.setInt(2,schedule.getRid());
        rs=ps.executeQuery();
        while (rs.next()){
            Bus bus=new Bus();
            bus.setBid(rs.getInt("bid"));
            bus.setBusName(rs.getString("busName"));
            buses.add(bus);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return buses;
}
    public List<Bus> getdateByName(Schedule schedule){
        List<Bus> buses=new ArrayList<>();
        Connection con=DBHelper.getInstance().getConnection();
        ResultSet rs;
        String query="SELECT bus.bid,  bus.busName FROM bus where bus.bid  in (select schedule.bid from schedule where schedule.date = ? and schedule.rid = ?)";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,schedule.getDate());
            ps.setInt(2,schedule.getRid());
            rs=ps.executeQuery();
            while (rs.next()){
                Bus bus=new Bus();
                bus.setBid(rs.getInt("bid"));
                bus.setBusName(rs.getString("busName"));
                buses.add(bus);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return buses;
    }
}