package by.epam.shop.dao.factory;

import by.epam.shop.dao.CategoryDao;
import by.epam.shop.dao.OrderDao;
import by.epam.shop.dao.ProductDao;
import by.epam.shop.dao.UserDao;
import by.epam.shop.dao.impl.CategoryDaoDBImpl;
import by.epam.shop.dao.impl.OrderDaoDBImpl;
import by.epam.shop.dao.impl.ProductDaoDBImpl;
import by.epam.shop.dao.impl.UserDaoDBImpl;
import by.epam.shop.dao.pool.ConnectionPool;

/**
 * Class that provides instances of DAO
 *
 * @author Shylvian Maksim
 *
 */
public class DaoFactory {

    private static ConnectionPool connectionPool = ConnectionPool.getInstance();

    private DaoFactory(){
        throw new IllegalStateException("Utility class");
    }

    public static ProductDao getProductDAO() {
        return new ProductDaoDBImpl(connectionPool);
    }

    public static CategoryDao getCategoryDAO() {
        return new CategoryDaoDBImpl(connectionPool);
    }

    public static OrderDao getOrderDAO() {
        return new OrderDaoDBImpl(connectionPool);
    }

    public static UserDao getUserDAO() {
        return new UserDaoDBImpl(connectionPool);
    }
}
