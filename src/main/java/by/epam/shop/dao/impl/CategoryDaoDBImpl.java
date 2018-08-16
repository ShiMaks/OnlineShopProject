package by.epam.shop.dao.impl;

import by.epam.shop.dao.AbstractDao;
import by.epam.shop.dao.CategoryDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoDBImpl extends AbstractDao implements CategoryDao {

    private static final String CREATE_CATEGORY = "";
    private static final String READ_CATEGORY_BY_ID = "";
    private static final String UPDATE_CATEGORY = "";
    private static final String DELETE_CATEGORY_BY_ID = "";
    private static final String READ_ALL_CATEGORIES = "";

    @Override
    public void create(Category entity) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_CATEGORY);){
            statement.setString(1, entity.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Category read(int id) throws DaoException {
        Category category = null;

        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_CATEGORY_BY_ID);
             ResultSet result = statement.executeQuery();){

            statement.setInt(1, id);

            if(result.next()) {
                category.setName(result.getString("Name"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return category;
    }

    @Override
    public void update(Category entity) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY);){
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CATEGORY_BY_ID);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Category> readAll() throws DaoException {
        List<Category> categories = new ArrayList<>();
        ResultSet resultSet = null;

        try (Connection connection = connect.getConnection(); Statement statement = connection.createStatement();) {

            resultSet = statement.executeQuery(READ_ALL_CATEGORIES);
            while(resultSet.next()) {
                Category category = new Category();
                category.setName(resultSet.getString("Name"));
                categories.add(category);
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
        return categories;
    }
}
