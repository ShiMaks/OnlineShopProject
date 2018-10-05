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

    private static final ConnectionPool connectionPool;
    private static final ProductDao productDao;
    private static final CategoryDao categoryDao;
    private static final OrderDao orderDao;
    private static final UserDao userDao;

    static {
        connectionPool = new ConnectionPool();
        productDao = new ProductDaoDBImpl(connectionPool);
        categoryDao = new CategoryDaoDBImpl(connectionPool);
        orderDao = new OrderDaoDBImpl(connectionPool);
        userDao = new UserDaoDBImpl(connectionPool);
    }

    private DaoFactory(){
        throw new IllegalStateException("Utility class");
    }

    public static ProductDao getProductDAO() {
        return productDao;
    }

    public static CategoryDao getCategoryDAO() {
        return categoryDao;
    }

    public static OrderDao getOrderDAO() {
        return orderDao;
    }

    public static UserDao getUserDAO() {
        return userDao;
    }
}
