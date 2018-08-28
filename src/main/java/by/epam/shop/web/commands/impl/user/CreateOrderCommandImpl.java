package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.*;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_SHOPPING_CART;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_USER;

public class CreateOrderCommandImpl implements BaseCommand{

    private OrderService orderService = ServiceFactory.getOrderService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
        ShopCart shopCart = (ShopCart) request.getSession().getAttribute(REQUEST_PARAM_SHOPPING_CART);
        List<OrderItem> orderItems = getOrderItems(shopCart);
        Order order = new Order();
        order.setIdClient(user.getId());

        return null;
    }

    List<OrderItem> getOrderItems(ShopCart cart){
        List<OrderItem> orderItems = new ArrayList<>();
        HashMap<Product, Integer> products = (HashMap<Product, Integer>) cart.getProducts();
        for(Map.Entry<Product, Integer> entry : products.entrySet()){
            OrderItem orderItem = new OrderItem();
            orderItem.setQuantity(entry.getValue());
            orderItem.setIdProduct(entry.getKey().getId());
            orderItem.setPrice((entry.getKey().getPrice())*(entry.getValue()));
            orderItems.add(orderItem);
        }
        return orderItems;
    }
}
