package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.Order;
import by.epam.shop.domain.User;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.epam.shop.web.util.PagePathConstant.PAGE_SHOP_ACCOUNT;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_USER;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_USER_ORDER;

public class PageUserOrdersCommandImpl implements BaseCommand {

    private OrderService orderService = ServiceFactory.getOrderService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
        List<Order> userOrders = orderService.getUserOrders(user.getId());
        request.setAttribute(REQUEST_PARAM_USER_ORDER, userOrders);
        return PAGE_SHOP_ACCOUNT;
    }
}
