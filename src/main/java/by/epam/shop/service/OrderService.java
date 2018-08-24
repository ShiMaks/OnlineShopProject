package by.epam.shop.service;

import by.epam.shop.domain.Order;
import by.epam.shop.domain.OrderItem;
import by.epam.shop.service.exception.ServiceException;

import java.util.List;

/**
 * Interface provides methods
 * for working with Order entity.
 *
 * @author Maksim Shilvian
 */
public interface OrderService {

    Order getOrder(int idOrder) throws ServiceException;

    List<Order> getAllOrders() throws ServiceException;

    List<OrderItem> getProductsOfOrder(int idOrder) throws ServiceException;
}
