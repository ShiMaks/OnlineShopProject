package by.epam.shop.dao.impl;

import by.epam.shop.dao.AbstractDao;
import by.epam.shop.dao.UserDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoDBImpl extends AbstractDao implements UserDao {

    private static final String CREATE_USER = "";
    private static final String READ_USER_BY_ID = "";
    private static final String UPDATE_USER = "";
    private static final String DELETE_USER_BY_ID = "";
    private static final String READ_ALL_USERS = "";

    @Override
    public void create(User user) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_USER);){
            //filling statement
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public User read(int id) throws DaoException {
        User user = null;
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_USER_BY_ID);
             ResultSet result = statement.executeQuery();){

            statement.setInt(1, id);

            if(result.next()) {
                //filling in an order
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return user;
    }

    @Override
    public void update(User user) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USER);){
            // filling satetement
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USER_BY_ID);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
