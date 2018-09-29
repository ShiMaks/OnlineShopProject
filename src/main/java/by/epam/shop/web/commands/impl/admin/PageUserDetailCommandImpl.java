package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Order;
import by.epam.shop.domain.User;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.UserService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.PAGE_USER_DETAIL;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_LIST_ORDERS;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_USER;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_USER_ID;

public class PageUserDetailCommandImpl implements BaseCommand {

    private UserService userService = ServiceFactory.getUserService();
    private OrderService orderService = ServiceFactory.getOrderService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idUser = request.getParameter(REQUEST_PARAM_USER_ID);
        if(!validatePositiveInt(idUser)){
            return PAGE_ERROR;
        }
        List<Order> orderList = orderService.getUserOrders(Integer.parseInt(idUser));
        User user = userService.getUser(Integer.parseInt(idUser));
        request.setAttribute(REQUEST_PARAM_USER, user);
        request.setAttribute(REQUEST_PARAM_LIST_ORDERS, orderList);
        return PAGE_USER_DETAIL;
    }
}
