package app.helpers;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private final String DRIVER="com.mysql.cj.jdbc.Driver";
    private final String URL="jdbc:mysql://localhost:3306/busticket";
    private final String USERNAME="root";
    private final String PASSWORD="rootroot";
    private static Connection con;
    private static DBHelper instance;

    private DBHelper() {
        try {
            Class.forName(DRIVER);
            con=DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static DBHelper getInstance() {
        if(instance==null) {
            instance=new DBHelper();
        }
        return instance;
    }
    public static Connection getConnection() {
        return con;
    }
}


