package by.epam.shop.dao;

import by.epam.shop.dao.pool.ConnectionPool;

public abstract class AbstractDao {

    protected ConnectionPool dataBaseConnection;

    public AbstractDao(ConnectionPool connectionPool){
        this.dataBaseConnection = connectionPool;
    }

//    public MySqlConnection connect;
//
//    {
//        connect = new MySqlConnection();
//    }


}
