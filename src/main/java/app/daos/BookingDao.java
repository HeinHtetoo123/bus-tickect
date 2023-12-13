package app.daos;

import app.helpers.DBHelper;
import app.models.Booking;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookingDao {
    public int createDetails(Booking booking) {
        int condition = 0;
        Connection con = DBHelper.getInstance().getConnection();
        String query = "insert into booking (bdid,seid) values (?,?);";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, booking.getBdid());
            ps.setInt(2, booking.getSeid());
            condition = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return condition;
    }
    public List<Booking> getSeatsBybdid(int bdid) {
        List<Booking> bookings=new ArrayList<>();
        ResultSet rs;
        Connection con= DBHelper.getInstance().getConnection();
        String query="SELECT * FROM booking WHERE bdid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,bdid );
            rs=ps.executeQuery();
            while (rs.next()) {
                Booking booking=new Booking();
                booking.setBdid(rs.getInt("bdid"));
                booking.setSeid(rs.getInt("seid"));
                bookings.add(booking);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
