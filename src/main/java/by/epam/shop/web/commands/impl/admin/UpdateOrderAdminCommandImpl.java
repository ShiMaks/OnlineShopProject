package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Order;
import by.epam.shop.domain.OrderStatusEnum;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_URL;
import static by.epam.shop.web.util.RequestParamValidator.validateParamNotNull;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.PAGE_TYPE_ADMIN_ORDERS;
import static by.epam.shop.web.util.WebConstantDeclaration.SESSION_PAGE_TYPE;

public class UpdateOrderAdminCommandImpl implements BaseCommand{

    private OrderService orderService = ServiceFactory.getOrderService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idOrder = request.getParameter("order_id");
        String status =request.getParameter("order_status");
        validateParamNotNull(status);
        if(validatePositiveInt(idOrder)) {
            Order order = new Order();
            order.setId(Integer.parseInt(idOrder));
            order.setStatus(valueOf(status));
            orderService.updateStatusOrder(order);
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_ORDERS);
            return REDIRECT_ADMIN_URL;
        } else {
            return PAGE_ERROR;
        }
    }

    private OrderStatusEnum valueOf(String value){
        if(value.toUpperCase().equals(OrderStatusEnum.NEW.toString())){
            return OrderStatusEnum.NEW;
        } else if(value.toUpperCase().equals(OrderStatusEnum.CANCELLED.toString())){
            return OrderStatusEnum.CANCELLED;
        } else if(value.toUpperCase().equals(OrderStatusEnum.PAYED.toString())){
            return OrderStatusEnum.PAYED;
        } else if(value.toUpperCase().equals(OrderStatusEnum.DELIVERED.toString())){
            return OrderStatusEnum.DELIVERED;
        } else {
            return null;
        }
    }
}
