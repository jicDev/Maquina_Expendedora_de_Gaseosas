package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    public static Connection connectar() {
        Connection conn = null;

        try {
            String url = "jdbc:h2:" + "./Database/expendedora";
            conn = DriverManager.getConnection(url, "user", "pass");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
