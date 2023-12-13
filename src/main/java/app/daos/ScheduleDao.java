package app.daos;

import app.helpers.DBHelper;
import app.models.Schedule;
import app.models.Search;
import app.models.SeatHp;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduleDao {
    public int createSchedule(Schedule schedule){
        int condition=0;
        Connection  con= DBHelper.getInstance().getConnection();
        String query="insert into schedule (price,date,departureTime,bid,rid) values(?,?,?,?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(query);

            ps.setInt(1,schedule.getPrice());
            ps.setString(2,schedule.getDate());
            ps.setString(3,schedule.getDepartureTime());
            ps.setInt(4,schedule.getBid());
            ps.setInt(5,schedule.getRid());
            condition=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         return condition;
    }
    public List<Schedule> getAllSchedules(){
        List<Schedule> schedules=new ArrayList<>();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select * from schedule";
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next())
            {
                Schedule schedule=new Schedule();
                schedule.setSid(rs.getInt("sid"));
                schedule.setPrice(rs.getInt("price"));
                schedule.setDate(rs.getString("date"));
                schedule.setDepartureTime(rs.getString("departureTime"));
                schedule.setBid(rs.getInt("bid"));
                schedule.setRid(rs.getInt("rid"));
                schedules.add(schedule);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
          return schedules;
    }
//    public List<Schedule> joinTable(){
//        String query = "SELECT b.busname, r.start, r.end " +
//                "FROM bus b " +
//                "JOIN schedule s ON b.bid = s.bid " +
//                "JOIN route r ON s.rid = r.rid";
//        List<Schedule> schedules=new ArrayList<>();
//        Connection con=DBHelper.getInstance().getConnection();
//        ResultSet rs;
//        try {
//            PreparedStatement ps=con.prepareStatement(query);
//            rs=ps.executeQuery();
//            while (rs.next()) {
//                Schedule schedule=new Schedule();
//                schedule.setSid(rs.getInt("sid"));
//                schedule.setScheduleId(rs.getString("scheduleId"));
//                schedule.setPrice(rs.getInt("price"));
//                schedule.setDate(rs.getDate("date"));
//                schedule.setBid(rs.getInt("bid"));
//                schedule.setRid(rs.getInt("rid"));
//                schedules.add(schedule);
//
//            }
//
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//       return schedules;
//
//    }
  public Schedule getScheduleById(int sid){
        Schedule schedule=new Schedule();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select * from schedule where sid=?";
        ResultSet rs;
      try {
          PreparedStatement ps=con.prepareStatement(query);
          ps.setInt(1,sid);
          rs=ps.executeQuery();
          while (rs.next()){
                schedule.setSid(rs.getInt("sid"));
                schedule.setPrice(rs.getInt("price"));
                schedule.setDate(rs.getString("date"));
                schedule.setDepartureTime(rs.getString("departureTime"));
                schedule.setBid(rs.getInt("bid"));
                schedule.setRid(rs.getInt("rid"));
          }
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return schedule;
  }

  public int updateSchedule(Schedule schedule){
        int condition=0;
        Connection con=DBHelper.getInstance().getConnection();
        String query="update schedule set price=?,date=?,departureTime=?,bid=?,rid=? where sid=?";
      try {
          PreparedStatement ps=con.prepareStatement(query);
          ps.setInt(1, schedule.getPrice());
          ps.setString(2, schedule.getDate());
          ps.setString(3,schedule.getDepartureTime());
          ps.setInt(4, schedule.getBid());
          ps.setInt(5, schedule.getRid());
          ps.setInt(6,schedule.getSid());
          condition=ps.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return condition;
  }
  public int deleteSchedule(int sid){
        int condition=0;
        Connection con=DBHelper.getInstance().getConnection();
        String query="delete from schedule where sid=?";
      try {
          PreparedStatement ps=con.prepareStatement(query);
          ps.setInt(1,sid);
          condition=ps.executeUpdate();
      } catch (SQLException e) {
          e.printStackTrace();
      }
      return condition;
  }


    public Schedule getLogin(Search search) {
        Schedule schedule = new Schedule();
        String query ="SELECT * FROM schedule WHERE rid=? AND date=?";
        Connection con= DBHelper.getInstance().getConnection();
        ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, search.getRid());
            ps.setString(2, search.getDate());
            rs = ps.executeQuery();
            while(rs.next()) {
                schedule.setSid(rs.getInt("sid"));
                schedule.setPrice(rs.getInt("price"));
                schedule.setDate(rs.getString("date"));
                schedule.setDepartureTime(rs.getString("departureTime"));
                schedule.setBid(rs.getInt("bid"));
                schedule.setRid(rs.getInt("rid"));
            }
        }catch(SQLException e) {
            //System.out.println("Database error");
            e.printStackTrace();
        }
        return schedule;
    }
    public List<Schedule> getScheduleByRid(Search search){
        List<Schedule> schedules = new ArrayList<>();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select * from schedule where rid=? and date=?";
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,search.getRid());
            ps.setString(2,search.getDate());
            rs=ps.executeQuery();
            while (rs.next()){
                Schedule schedule = new Schedule();
                schedule.setSid(rs.getInt("sid"));
                schedule.setPrice(rs.getInt("price"));
                schedule.setDate(rs.getString("date"));
                schedule.setDepartureTime(rs.getString("departureTime"));
                schedule.setBid(rs.getInt("bid"));
                schedule.setRid(rs.getInt("rid"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }
    public List<Schedule> search(String date) {
        List<Schedule> schedules = new ArrayList<>();
        Connection con = DBHelper.getInstance().getConnection();
        StringBuilder query = new StringBuilder("SELECT * FROM schedule WHERE 1=1");

        if (!date.isEmpty()) {
            query.append(" AND date = ?");
        }

        try {
            PreparedStatement ps = con.prepareStatement(query.toString());

            if (!date.isEmpty()) {
                ps.setString(1, date);
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setSid(rs.getInt("sid"));
                schedule.setPrice(rs.getInt("price"));
                schedule.setDate(rs.getString("date"));
                schedule.setDepartureTime(rs.getString("departureTime"));
                schedule.setBid(rs.getInt("bid"));
                schedule.setRid(rs.getInt("rid"));
                schedules.add(schedule);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

    public Schedule getSeatSearchHp(SeatHp seatHp){
        Schedule schedule=new Schedule();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select * from schedule where rid=? AND date=? AND bid=?";
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,seatHp.getRid());
            ps.setString(2,seatHp.getDate());
            ps.setInt(3,seatHp.getBid());
            rs=ps.executeQuery();
            while (rs.next()){
                schedule.setSid(rs.getInt("sid"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedule;
    }
    public List<Schedule> getAllSchedulesBysid(int sid){
        List<Schedule> schedules=new ArrayList<>();
        Connection con=DBHelper.getInstance().getConnection();
        String query="select * from schedule where sid=?";
        ResultSet rs;
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,sid);
            rs=ps.executeQuery();
            while (rs.next())
            {
                Schedule schedule=new Schedule();
                schedule.setSid(rs.getInt("sid"));
                schedule.setPrice(rs.getInt("price"));
                schedule.setDate(rs.getString("date"));
                schedule.setDepartureTime(rs.getString("departureTime"));
                schedule.setBid(rs.getInt("bid"));
                schedule.setRid(rs.getInt("rid"));
                schedules.add(schedule);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }
    public List<Schedule> getSchedule(Search search) {
        List<Schedule> schedules=new ArrayList<>();
        String query ="SELECT * FROM schedule WHERE date=? AND rid=?";
        Connection con=DBHelper.getInstance().getConnection();
        ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, search.getDate());
            ps.setInt(2, search.getRid());
            rs = ps.executeQuery();
            while(rs.next()) {
                Schedule schedule=new Schedule();
                schedule.setSid(rs.getInt("sid"));
                schedule.setPrice(rs.getInt("price"));
                schedule.setDate(rs.getString("date"));
                schedule.setDepartureTime(rs.getString("departureTime"));
                schedule.setRid(rs.getInt("rid"));
                schedule.setBid(rs.getInt("bid"));
                schedules.add(schedule);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
        return schedules;
    }

}
