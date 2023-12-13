package app.daos;

import app.helpers.DBHelper;
import app.models.Route;
import app.models.StartandEnd;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class RouteDao {
    public int createRoute(Route rou){
        int condition=0;
        Connection con= DBHelper.getInstance().getConnection();
        String query="INSERT INTO route (start,end) VALUES (?,?)";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,rou.getStart());
            ps.setString(2,rou.getEnd());
            condition=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;
    }

    public List<Route> getAllRoutes(){
        List<Route> routes=new ArrayList<>();
        ResultSet rs;
        Connection con= DBHelper.getInstance().getConnection();
        String query="SELECT * FROM route";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            rs=ps.executeQuery();
            while (rs.next()){
                Route route=new Route();
                route.setRid(rs.getInt("rid"));
                route.setStart(rs.getString("start"));
                route.setEnd(rs.getString("end"));
                routes.add(route);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return routes;

    }
    public Route getRouteById(int rid){
        Route rou=new Route();
        ResultSet rs;
        Connection con= DBHelper.getInstance().getConnection();
        String query="SELECT * FROM route WHERE rid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,rid);
            rs=ps.executeQuery();
            while (rs.next()){
                rou.setRid(rs.getInt("rid"));
                rou.setStart(rs.getString("start"));
                rou.setEnd(rs.getString("end"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rou;
    }
    public int updateRoute(Route route){
        int condition=0;
        Connection con= DBHelper.getInstance().getConnection();
        String query="UPDATE route SET start=?,end=? WHERE rid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,route.getStart());
            ps.setString(2,route.getEnd());
            ps.setInt(3,route.getRid());
            condition=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;
    }
    public int deleteRoute(int rid){
        int condition=0;
        Connection con= DBHelper.getInstance().getConnection();
        String query="DELETE FROM route WHERE rid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,rid);
            condition=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;
    }
    public Route getRouteByRid(StartandEnd startandEnd){
        Route rou=new Route();
        ResultSet rs;
        Connection con= DBHelper.getInstance().getConnection();
        String query="SELECT * FROM route WHERE start=? and end=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,startandEnd.getRid());
            ps.setString(2,startandEnd.getEnd());
            rs=ps.executeQuery();
            while (rs.next()){
                rou.setRid(rs.getInt("rid"));
                rou.setStart(rs.getString("start"));
                rou.setEnd(rs.getString("end"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rou;
    }



}