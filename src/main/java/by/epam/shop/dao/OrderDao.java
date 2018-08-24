package by.epam.shop.dao;

import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Order;
import by.epam.shop.domain.OrderItem;
import by.epam.shop.domain.OrderStatusEnum;

import java.util.List;

/**
 * Interface that provides additional methods
 * to access order data from database.
 *
 * @author Shilvian Maksim
 */
public interface OrderDao extends BaseDao<Order> {

    /**
     * Gets all existing orders from database
     *
     * @return List of orders
     * @throws DaoException
     */
    List<Order> readAll() throws DaoException;

    /**
     * Gets all orders of order
     *
     * @param idOrder
     * @return List of OrderItem
     */
    List<OrderItem> getProductsOfOrder(int idOrder) throws DaoException;


    /**
     * Gets all orders by status
     *
     * @param status
     * @return List of orders
     * @throws DaoException
     */
    List<Order> getOrdersByStatus(String status) throws DaoException;

}
