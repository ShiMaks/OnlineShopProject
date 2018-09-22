package by.epam.shop.dao;

import by.epam.shop.dao.pool.ConnectionPool;
import by.epam.shop.dao.pool.MySqlConnection;

public abstract class AbstractDao {

//    protected ConnectionPool dataBaseConnection = ConnectionPool.getInstance();
//
//    public AbstractDao(ConnectionPool connectionPool){
//        this.dataBaseConnection = connectionPool;
//    }

    public MySqlConnection connect;

    {
        connect = new MySqlConnection();
    }


}
