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

    /**
     * Creates a custom order
     *
     * @param order
     * @param orderItems
     * @throws ServiceException
     */
    void createOrder(Order order, List<OrderItem> orderItems) throws ServiceException;

    /**
     * Gets order
     *
     * @param idOrder
     * @return int idOrder
     * @throws ServiceException
     */
    Order getOrder(int idOrder) throws ServiceException;

    /**
     * Update status of order
     *
     * @param order
     * @throws ServiceException
     */
    void updateStatusOrder(Order order) throws ServiceException;

    /**
     * Gets full list of orders
     *
     * @return List of orders
     * @throws ServiceException
     */
    List<Order> getAllOrders() throws ServiceException;

    /**
     * Gets list products of order
     *
     * @param idOrder
     * @return List of order item
     * @throws ServiceException
     */
    List<OrderItem> getProductsOfOrder(int idOrder) throws ServiceException;

    /**
     * Gets list of orders by status
     *
     * @param status
     * @return List of orders
     * @throws ServiceException
     */
    List<Order> getOrdersByStatus(String status) throws ServiceException;

    /**
     * Gets user's orders
     *
     * @param idUser
     * @return List of orders
     * @throws ServiceException
     */
    List<Order> getUserOrders(int idUser)  throws ServiceException;
}
