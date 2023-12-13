package app.daos;
import app.helpers.DBHelper;
import app.models.Admin;
import app.models.Login;
import org.springframework.stereotype.Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminDao {
    public int createAdmin(Admin admin) {
        int condition = 0;
        Connection con = DBHelper.getInstance().getConnection();
        String query = "INSERT INTO admin (aid,name,email,password) VALUES (?,?,?,?)";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, admin.getId());

            ps.setString(2, admin.getName());
            ps.setString(3, admin.getEmail());
            ps.setString(4, admin.getPassword());

            condition = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return condition;

    }
    public Admin getLogin(Login login) {
        Admin admin = new Admin();
        String query ="SELECT * FROM admin WHERE email=? AND password=?";
        Connection con= DBHelper.getInstance().getConnection();
        ResultSet rs;
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, login.getEmail());
            ps.setString(2, login.getPassword());
            rs = ps.executeQuery();
            while(rs.next()) {
                admin.setId(rs.getInt("aid"));
                admin.setName(rs.getString("name"));
                admin.setEmail(rs.getString("email"));
                admin.setPassword(rs.getString("password"));
            }
        }catch(SQLException e) {
            //System.out.println("Database error");
            e.printStackTrace();
        }
        return admin;
    }
   public List<Admin> getAllAdmins()  {
        List<Admin> admins=new ArrayList<>();
        Connection con= DBHelper.getInstance().getConnection();
        String query="select * from admin";
        ResultSet rs;
       try {
           PreparedStatement ps = con.prepareStatement(query);
           rs = ps.executeQuery();
           while(rs.next()) {
               Admin admin=new Admin();
               admin.setId(rs.getInt("aid"));
               admin.setName(rs.getString("name"));
               admin.setEmail(rs.getString("email"));
               admin.setPassword(rs.getString("password"));
               admins.add(admin);
           }
       }catch(SQLException e) {
           //System.out.println("Database error");
           e.printStackTrace();
       }
        return admins;
   }
   public Admin getAdminById(int aid){
        Admin admin=new Admin();
        Connection con= DBHelper.getInstance().getConnection();
        String query="select * from admin where aid=?";
        ResultSet rs;
       try {
           PreparedStatement ps=con.prepareStatement(query);
           ps.setInt(1,aid);
           rs=ps.executeQuery();
           while (rs.next()){
               admin.setId(rs.getInt("aid"));

               admin.setName(rs.getString("name"));
               admin.setEmail(rs.getString("email"));
               admin.setPassword(rs.getString("password"));
           }
       } catch (SQLException e) {

       }
       return admin;
   }
    public int updateAdmin(Admin admin) {
        int condition=0;
        Connection con= DBHelper.getInstance().getConnection();
        String query="UPDATE admin SET name=?,email=?,password=? WHERE aid=?";
        try {
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, admin.getName());
            ps.setString(2, admin.getEmail());
            ps.setString(3, admin.getPassword());
            ps.setInt(4, admin.getId());
            condition=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return condition;
    }
    public int deleteAdmin(int aid) {
        int condition=0;
        Connection con= DBHelper.getInstance().getConnection();
        String query="DELETE FROM admin WHERE aid=?";
        try {

            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1,aid);
            condition=ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return condition;
    }

}
