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

    private static final CategoryService categoryService = new CategoryServiceImpl();
    private static final ProductService productService = new ProductServiceImpl();
    private static final OrderService orderService = new OrderServiceImpl();
    private static final UserService userService = new UserServiceImpl();

    private ServiceFactory(){
        throw new IllegalStateException("Utility class");
    }

    public static CategoryService getCategoryService(){
        return categoryService;
    }

    public static ProductService getProductService(){
        return productService;
    }

    public static UserService getUserService(){
        return userService;
    }

    public static OrderService getOrderService(){
        return orderService;
    }
}
