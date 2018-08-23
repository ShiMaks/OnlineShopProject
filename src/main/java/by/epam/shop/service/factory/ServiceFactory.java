package by.epam.shop.service.factory;

import by.epam.shop.service.CategoryService;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.UserService;
import by.epam.shop.service.impl.CategoryServiceImpl;
import by.epam.shop.service.impl.ProductServiceImpl;
import by.epam.shop.service.impl.UserServiceImpl;

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
}
