package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Order;
import by.epam.shop.domain.OrderStatusEnum;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_URL;
import static by.epam.shop.web.util.RequestParamValidator.validateParamNotNull;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class UpdateOrderAdminCommandImpl implements BaseCommand{

    private static final Logger LOGGER = LogManager.getLogger(AddProductCommandImpl.class);

    private OrderService orderService = ServiceFactory.getOrderService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idOrder = request.getParameter(REQUEST_PARAM_ORDER_ID);
        String status =request.getParameter(REQUEST_PARAM_ORDER_STATUS);
        validateParamNotNull(status);
        if(validatePositiveInt(idOrder)) {
            Order order = new Order();
            order.setId(Integer.parseInt(idOrder));
            order.setStatus(OrderStatusEnum.valueOf(status.toUpperCase()));
            orderService.updateStatusOrder(order);
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_ORDERS);
            LOGGER.info("Order id={} status updated {}", idOrder, status.toUpperCase());
            return REDIRECT_ADMIN_URL;
        } else {
            return PAGE_ERROR;
        }
    }
}
