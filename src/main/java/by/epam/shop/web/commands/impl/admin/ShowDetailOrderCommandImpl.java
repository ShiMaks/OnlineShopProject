package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Order;
import by.epam.shop.domain.OrderItem;
import by.epam.shop.domain.OrderStatusEnum;
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
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;

public class ShowDetailOrderCommandImpl implements BaseCommand{

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
            return "jsp/updateOrderAdmin.jsp";
        } else {
            return PAGE_ERROR;
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
