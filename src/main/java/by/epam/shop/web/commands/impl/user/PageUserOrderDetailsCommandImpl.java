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
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_USER_URL;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.PAGE_TYPE_USER_ORDERS;
import static by.epam.shop.web.util.WebConstantDeclaration.SESSION_PAGE_TYPE;

public class PageUserOrderDetailsCommandImpl implements BaseCommand {

    private OrderService orderService = ServiceFactory.getOrderService();
    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idOrder = request.getParameter("order_id");
        if(validatePositiveInt(idOrder)) {
            List<OrderItem> orderItems = orderService.getProductsOfOrder(Integer.parseInt(idOrder));
            Order order = orderService.getOrder(Integer.parseInt(idOrder));
            request.setAttribute("listProducts", getProducts(orderItems));
            request.setAttribute("order", order);
            return "/jsp/pages/order-details.jsp";
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
