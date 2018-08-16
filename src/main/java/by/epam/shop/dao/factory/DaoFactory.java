package by.epam.shop.dao.factory;

import by.epam.shop.dao.CategoryDao;
import by.epam.shop.dao.ProductDao;
import by.epam.shop.dao.impl.CategoryDaoDBImpl;
import by.epam.shop.dao.impl.ProductDaoDBImpl;

/**
 * Class that provides instances of DAO
 *
 * @author Shylvian Maksim
 *
 */
public class DaoFactory {

    private DaoFactory(){
        throw new IllegalStateException("Utility class");
    }

    public static ProductDao getProductDAO() {
        return new ProductDaoDBImpl();
    }

    public static CategoryDao getCategoryDAO() {
        return new CategoryDaoDBImpl();
    }

}
