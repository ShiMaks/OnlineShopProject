package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.*;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.*;

import static by.epam.shop.web.util.PagePathConstant.REDIRECT_USER_URL;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class CreateOrderCommandImpl implements BaseCommand{

    private static final Logger LOGGER = LogManager.getLogger(CreateOrderCommandImpl.class);

    private static final String MESSAGE_SUCCESS = "success_create_order";
    private static final String MESSAGE_NOT_SUCCESS = "not_success_create_order";

    private OrderService orderService = ServiceFactory.getOrderService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
        ShopCart shopCart = (ShopCart) request.getSession().getAttribute(REQUEST_PARAM_SHOPPING_CART);
        List<OrderItem> orderItems = getOrderItems(shopCart);
        Order order = createOrder(shopCart, user);
        try{
            orderService.createOrder(order, orderItems);
            shopCart.cleanCart();
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_USER_ORDERS);
            request.getSession().setAttribute(REQUEST_PARAM_SESSION_MESSAGE, MESSAGE_SUCCESS);
            LOGGER.info("Order {} successfully created", order);
            return REDIRECT_USER_URL;
        } catch (ServiceException e){
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_USER_CART);
            request.getSession().setAttribute(REQUEST_PARAM_SESSION_MESSAGE, MESSAGE_NOT_SUCCESS);
            return REDIRECT_USER_URL;
        }
    }

    private List<OrderItem> getOrderItems(ShopCart cart){
        List<OrderItem> orderItems = new ArrayList<>();
        HashMap<Product, Integer> products = (HashMap<Product, Integer>) cart.getProducts();
        for(Map.Entry<Product, Integer> entry : products.entrySet()){
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(entry.getValue());
            orderItem.setIdProduct(entry.getKey().getId());
            orderItem.setPrice((entry.getKey().getPrice()));
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    private Order createOrder(ShopCart shopCart,User user){
        Order order = new Order();
        order.setIdClient(user.getId());
        order.setStatus(OrderStatusEnum.NEW);
        order.setDataOrder(new Date());
        order.setOrderCost(shopCart.getTotalCost());
        return order;
    }
}
