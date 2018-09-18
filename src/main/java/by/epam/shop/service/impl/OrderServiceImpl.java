package by.epam.shop.service.impl;

import by.epam.shop.dao.OrderDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.factory.DaoFactory;
import by.epam.shop.domain.Order;
import by.epam.shop.domain.OrderItem;
import by.epam.shop.service.OrderService;
import by.epam.shop.service.exception.ServiceException;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = DaoFactory.getOrderDAO();

    @Override
    public void createOrder(Order order, List<OrderItem> orderItems) throws ServiceException {

    }

    @Override
    public Order getOrder(int idOrder) throws ServiceException {
        return orderDao.read(idOrder);
    }

    @Override
    public void updateStatusOrder(Order order) throws ServiceException {
        orderDao.update(order);
    }

    @Override
    public List<Order> getAllOrders() throws ServiceException {
        try {
            return orderDao.readAll();
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderItem> getProductsOfOrder(int idOrder) throws ServiceException {
        return orderDao.getProductsOfOrder(idOrder);
    }

    @Override
    public List<Order> getOrdersByStatus(String status) throws ServiceException {
        return orderDao.getOrdersByStatus(status);
    }

    @Override
    public List<Order> getUserOrders(int idUser) throws ServiceException {
        return null;
    }
}
