package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.Order;
import by.epam.shop.domain.OrderItem;
import by.epam.shop.domain.Product;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.PAGE_SHOP_USER_ORDER_DETAIL;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_USER_URL;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class PageUserOrderDetailsCommandImpl implements BaseCommand {

    private OrderService orderService = ServiceFactory.getOrderService();
    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idOrder = request.getParameter(REQUEST_PARAM_ORDER_ID);
        if(validatePositiveInt(idOrder)) {
            List<OrderItem> orderItems = orderService.getProductsOfOrder(Integer.parseInt(idOrder));
            Order order = orderService.getOrder(Integer.parseInt(idOrder));
            request.setAttribute(REQUEST_PARAM_LIST_PRODUCT, getProducts(orderItems));
            request.setAttribute(REQUEST_PARAM_ORDER, order);
            return PAGE_SHOP_USER_ORDER_DETAIL;
        } else {
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_USER_ORDERS);
            return REDIRECT_USER_URL;
        }
    }

    private List<Product> getProducts(List<OrderItem> orderItems) throws ServiceException {
        List<Product> products = new ArrayList<>();
        for(OrderItem orderItem: orderItems){
            Product product;
            int idProduct = orderItem.getIdProduct();
            product = productService.getProduct(idProduct);
            products.add(product);
        }
        return products;
    }
}
