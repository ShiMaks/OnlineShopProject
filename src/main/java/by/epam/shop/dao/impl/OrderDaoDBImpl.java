package by.epam.shop.dao.impl;

import by.epam.shop.dao.AbstractDao;
import by.epam.shop.dao.OrderDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.pool.ConnectionPool;
import by.epam.shop.domain.Order;
import by.epam.shop.domain.OrderItem;
import by.epam.shop.domain.OrderStatusEnum;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for working with the order table from database
 *
 * @author Shilvian Maksim
 */
public class OrderDaoDBImpl extends AbstractDao implements OrderDao {

    private static final Logger LOGGER = LogManager.getLogger(OrderDaoDBImpl.class);

    /**
     * SQL-statements
     */
    private static final String CREATE_ORDER = "INSERT INTO shop_order (client_id, status, dataOrder, price) " +
            "VALUES (?, ?, ?, ?)";
    private static final String CREATE_ORDER_ITEM ="INSERT INTO order_item (order_id, product_id, quantity, price) " +
            "VALUES (?, ?, ?, ?)";
    private static final String READ_ORDER_BY_ID = "SELECT id, client_id, status, dataOrder, price FROM shop_order " +
            "WHERE id = ?";
    private static final String UPDATE_ORDER = "UPDATE shop_order SET status = ? WHERE id = ?";
    private static final String DELETE_ORDER_BY_ID = "DELETE FROM shop_order WHERE id  = ?";
    private static final String READ_ALL_ORDERS = "SELECT id, client_id, status, dataOrder, price FROM shop_order";
    private static final String READ_PRODUCTS_OF_ORDER = "SELECT order_id, product_id, quantity, price FROM order_item " +
            "WHERE order_id = ?";
    private static final String READ_ORDER_BY_STATUS = "SELECT id, client_id, status, dataOrder, price FROM shop_order" +
            " WHERE status = ?";
    private static final String READ_ALL_ORDERS_USER = "SELECT id, client_id, status, dataOrder, price FROM shop_order" +
            " WHERE client_id = ?";

    public OrderDaoDBImpl(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    public void createOrder(Order order, List<OrderItem> orderItems) throws DaoException {
        int id = 0;
        Connection connection = dataBaseConnection.getConnection();
        try {
            connection.setAutoCommit(false);
            try (PreparedStatement orderPreparedStatement = connection.prepareStatement(CREATE_ORDER,
                    Statement.RETURN_GENERATED_KEYS);
                 PreparedStatement orderItemPreparedStatement = connection.prepareStatement(CREATE_ORDER_ITEM,
                         Statement.RETURN_GENERATED_KEYS)) {
                orderPreparedStatement.setInt(1, order.getIdClient());
                orderPreparedStatement.setString(2, order.getStatus().toString());
                orderPreparedStatement.setString(3, getDateTime(order.getDataOrder()));
                orderPreparedStatement.setInt(4, order.getOrderCost());
                orderPreparedStatement.executeUpdate();
                ResultSet resultSet = orderPreparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    id = resultSet.getInt(1);
                }

                for(OrderItem orderItem: orderItems) {
                    orderItemPreparedStatement.setInt(1, id);
                    orderItemPreparedStatement.setInt(2, orderItem.getIdProduct());
                    orderItemPreparedStatement.setInt(3, orderItem.getQuantity());
                    orderItemPreparedStatement.setInt(4, orderItem.getPrice());
                    orderItemPreparedStatement.executeUpdate();
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw new DaoException(e);
            } finally {
                connection.setAutoCommit(true);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } catch (DaoException daoException) {
            daoException.printStackTrace();
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    @Override
    public void create(Order entity) throws DaoException {

    }

    @Override
    public Order read(int id) throws DaoException {
        Order order = new Order();
        ResultSet result = null;
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(READ_ORDER_BY_ID)){
            statement.setInt(1, id);
            result = statement.executeQuery();
            if(result.next()) {
                order.setId(result.getInt("id"));
                order.setIdClient(result.getInt("client_id"));
                order.setStatus(valueOf(result.getString("status")));
                order.setDataOrder(result.getDate("dataOrder"));
                order.setOrderCost(result.getInt("price"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
        return order;
    }

    @Override
    public void update(Order order) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER);){
            statement.setString(1, order.getStatus().toString());
            statement.setInt(2, order.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_BY_ID)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    @Override
    public List<Order> readAll() throws DaoException {
        List<Order> orders = new ArrayList<>();
        ResultSet resultSet = null;
        Connection connection = dataBaseConnection.getConnection();
        try (Statement statement = connection.createStatement()) {
            resultSet = statement.executeQuery(READ_ALL_ORDERS);
            while(resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setIdClient(resultSet.getInt("client_id"));
                order.setStatus(valueOf(resultSet.getString("status")));
                order.setDataOrder(resultSet.getDate("dataOrder"));
                order.setOrderCost(resultSet.getInt("price"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
        return orders;
    }

    @Override
    public List<OrderItem> getProductsOfOrder(int idOrder) throws DaoException {
        List<OrderItem> orderItems = new ArrayList<>();
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(READ_PRODUCTS_OF_ORDER);){
            preparedStatement.setInt(1, idOrder);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setIdProduct(resultSet.getInt("product_id"));
                orderItem.setQuantity(resultSet.getInt("quantity"));
                orderItems.add(orderItem);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
        return orderItems;
    }

    @Override
    public List<Order> getOrdersByStatus(String status) throws DaoException {
        List<Order> orders = new ArrayList<>();
        ResultSet result = null;
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(READ_ORDER_BY_STATUS)){
            statement.setString(1, status);
            result = statement.executeQuery();
            while(result.next()) {
                Order order = new Order();
                order.setId(result.getInt("id"));
                order.setIdClient(result.getInt("client_id"));
                order.setStatus(valueOf(result.getString("status")));
                order.setDataOrder(result.getDate("dataOrder"));
                order.setOrderCost(result.getInt("price"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            dataBaseConnection.returnConnection(connection);
        }
        return orders;
    }

    @Override
    public List<Order> getUserOrders(int idUser) throws DaoException {
        List<Order> orders = new ArrayList<>();
        ResultSet result = null;
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(READ_ALL_ORDERS_USER)){
            statement.setInt(1, idUser);
            result = statement.executeQuery();
            while(result.next()) {
                Order order = new Order();
                order.setId(result.getInt("id"));
                order.setIdClient(result.getInt("client_id"));
                order.setStatus(valueOf(result.getString("status")));
                order.setDataOrder(result.getDate("dataOrder"));
                order.setOrderCost(result.getInt("price"));
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            dataBaseConnection.returnConnection(connection);
        }

//        OrderStatusEnum.valueOf("sdfsdf".toUpperCase());
        return orders;
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

    private String getDateTime(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return dateFormat.format(date);
    }
}
