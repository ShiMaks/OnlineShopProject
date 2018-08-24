package by.epam.shop.service.factory;

import by.epam.shop.service.CategoryService;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.UserService;
import by.epam.shop.service.impl.CategoryServiceImpl;
import by.epam.shop.service.impl.OrderServiceImpl;
import by.epam.shop.service.impl.ProductServiceImpl;
import by.epam.shop.service.impl.UserServiceImpl;

/**
 * Class that provides instances of Service objects
 *
 * @author Maksim Shilvian
 *
 */
public class ServiceFactory {

    private ServiceFactory(){
        throw new IllegalStateException("Utility class");
    }

    public static CategoryService getCategoryService(){
        return new CategoryServiceImpl();
    }

    public static ProductService getProductService(){
        return new ProductServiceImpl();
    }

    public static UserService getUserService(){
        return new UserServiceImpl();
    }

    public static OrderService getOrderService(){
        return new OrderServiceImpl();
    }
}
