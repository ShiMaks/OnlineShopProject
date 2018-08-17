package by.epam.shop.dao.impl;

import by.epam.shop.dao.AbstractDao;
import by.epam.shop.dao.OrderDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoDBImpl extends AbstractDao implements OrderDao {

    private static final String CREATE_ORDER = "";
    private static final String READ_ORDER_BY_ID = "";
    private static final String UPDATE_ORDER = "";
    private static final String DELETE_ORDER_BY_ID = "";
    private static final String READ_ALL_ORDERS = "";

    @Override
    public void create(Order order) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_ORDER);){
                //filling statement
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Order read(int id) throws DaoException {
        Order order = null;
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_ORDER_BY_ID);
             ResultSet result = statement.executeQuery();){

            statement.setInt(1, id);

            if(result.next()) {
                //filling in an order
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return order;
    }

    @Override
    public void update(Order order) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_ORDER);){
            // filling satetement
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_ORDER_BY_ID);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Order> readAll() throws DaoException {
        List<Order> orders = new ArrayList<>();
        ResultSet resultSet = null;

        try (Connection connection = connect.getConnection(); Statement statement = connection.createStatement();) {

            resultSet = statement.executeQuery(READ_ALL_ORDERS);
            while(resultSet.next()) {
                Order order = new Order();
                //create order
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            if(resultSet!=null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return orders;
    }
}
