package by.epam.shop.web.commands.impl.user;

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

import static by.epam.shop.web.util.PagePathConstant.PAGE_CART;
import static by.epam.shop.web.util.PagePathConstant.PAGE_INDEX;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class RedirectUserCommandImpl implements BaseCommand{

    private OrderService orderService = ServiceFactory.getOrderService();
    UserService userService = ServiceFactory.getUserService();
    private ProductService productService = ServiceFactory.getProductService();
    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String pageType = (String) request.getSession().getAttribute(SESSION_PAGE_TYPE);
        switch (pageType) {
            case PAGE_TYPE_USER_ORDERS:
                User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
                List<Order> userOrders;
                userOrders = orderService.getUserOrders(user.getId());
                request.setAttribute("userOrders", userOrders);
                return "/jsp/pages/shop-account.jsp";
            case PAGE_TYPE_USER_CART:
                return PAGE_CART;
            case PAGE_TYPE_USER_INFO:
                User sessionUser = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
                User userInfo = userService.getUser(sessionUser.getId());
                request.setAttribute("userInform", userInfo);
                return "/jsp/pages/profile-account.jsp";
            case PAGE_TYPE_USER_MAIN:
                List<Category> categories = categoryService.getCategories();
                List<Product> products = productService.getProducts();
                request.setAttribute("listCategory", categories);
                request.setAttribute("listProduct", products);
                return "/jsp/pages/indexNew.jsp";
            default:
                return PAGE_INDEX;
        }
    }
}
