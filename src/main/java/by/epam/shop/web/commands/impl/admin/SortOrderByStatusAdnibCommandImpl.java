package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Order;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import static by.epam.shop.web.util.RequestParamValidator.validateParamNotNull;


public class SortOrderByStatusAdnibCommandImpl implements BaseCommand{

    private OrderService orderService = ServiceFactory.getOrderService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String status = request.getParameter("order_status");
        validateParamNotNull(status);
        List<Order> orders = orderService.getOrdersByStatus(status);
        request.setAttribute("listOrders", orders);
        return "jsp/ordersAdmin.jsp";
    }
}
