package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Order;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ORDERS_ADMIN;

public class PageOrdersAdminCommandImpl implements BaseCommand {

    private OrderService orderService = ServiceFactory.getOrderService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        List<Order> orders = orderService.getAllOrders();
        request.setAttribute("listOrders", orders);
        return PAGE_ORDERS_ADMIN;
    }
}
