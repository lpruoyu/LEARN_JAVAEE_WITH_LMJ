package programmer.lp.obj;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String url;
    private String username;
    private String password;

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //
//    public static Connection getConnection() {
//        try {
//            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test_mybatis", "root", "root");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
