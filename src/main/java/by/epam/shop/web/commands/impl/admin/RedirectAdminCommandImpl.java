package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Category;
import by.epam.shop.domain.Order;
import by.epam.shop.domain.Product;
import by.epam.shop.domain.User;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.UserService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.epam.shop.web.util.PagePathConstant.*;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class RedirectAdminCommandImpl implements BaseCommand{
    
    private CategoryService categoryService = ServiceFactory.getCategoryService();
    private ProductService productService = ServiceFactory.getProductService();
    private UserService userService = ServiceFactory.getUserService();
    private OrderService orderService = ServiceFactory.getOrderService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String pageType = (String) request.getSession().getAttribute(SESSION_PAGE_TYPE);
        switch (pageType) {
            case PAGE_TYPE_ADMIN_CATEGORY:
               List<Category> categories;
               categories = categoryService.getCategories();
               request.setAttribute(REQUEST_PARAM_LIST_CATEGORIES_ADMIN, categories);
               request.setAttribute(REQUEST_PARAM_INFO_MESSAGE,
                       request.getSession().getAttribute(REQUEST_PARAM_SESSION_MESSAGE));
               return PAGE_CATEGORY_ADMIN;
            case PAGE_TYPE_ADMIN_PRODUCT:
               List<Product> products;
               products = productService.getProducts();
               request.setAttribute(REQUEST_PARAM_LIST_PRODUCTS_ADMIN, products);
               request.setAttribute(REQUEST_PARAM_INFO_MESSAGE,
                       request.getSession().getAttribute(REQUEST_PARAM_SESSION_MESSAGE));
               return PAGE_PRODUCTS_ADMIN;
            case PAGE_TYPE_ADMIN_ORDERS:
               List<Order> orders = orderService.getAllOrders();
               request.setAttribute(REQUEST_PARAM_LIST_ORDERS, orders);
               return PAGE_ORDERS_ADMIN;
            case PAGE_TYPE_ADMIN:
               List<User> users = userService.getUsers();
               request.setAttribute(REQUEST_PARAM_USERS, users);
               return PAGE_ADMIN;
            default:
                return PAGE_INDEX;
        }
    }
}
