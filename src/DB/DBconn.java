package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by wanghanqing on 2017/5/25.
 */
public class DBconn {
    private static final String url="jdbc:mysql://127.0.0.1:3306/shopping?characterEncoding=utf8&useSSL=true";
    private static final String user="root";
    private static final String password="wanghanqing";
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection= DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection(){
        return connection;
    }
}
