package by.epam.shop.dao.pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnection implements AutoCloseable {

    private Connection connect;

    public Connection getConnection() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/shop?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
        String user = "root";
        String pass = "root";
        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver).newInstance();
            connect = DriverManager.getConnection(url, user, pass);

        } catch(ClassNotFoundException e) {
            throw new SQLException("Driver not loaded", e);
        } catch (InstantiationException  | IllegalAccessException e) {
            e.printStackTrace();
        }
        return connect;
    }

    @Override
    public void close() throws Exception {
        connect.close();

    }
}
