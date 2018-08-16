package by.epam.shop.dao;

import by.epam.shop.dao.pool.MySqlConnection;

public abstract class AbstractDao {

    public MySqlConnection connect;

    {
        connect = new MySqlConnection();
    }
}
