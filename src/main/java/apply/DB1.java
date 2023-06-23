package apply;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB1 {

    private static final String JDBC_URL = "jdbc:mysql://apply.cwk0hb539k4f.ap-northeast-2.rds.amazonaws.com:3306/apply?useUnicode=true&characterEncoding=utf8";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "hanaro6666!";

    public static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
