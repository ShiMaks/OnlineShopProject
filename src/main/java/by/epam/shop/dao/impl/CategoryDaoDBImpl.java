package by.epam.shop.dao.impl;

import by.epam.shop.dao.AbstractDao;
import by.epam.shop.dao.CategoryDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for working with the category table from database
 *
 * @author Shilvian Maksim
 */
public class CategoryDaoDBImpl extends AbstractDao implements CategoryDao {

    private static final Logger LOGGER = LogManager.getLogger(CategoryDaoDBImpl.class);

    /**
     * SQL-statements
     */
    private static final String CREATE_CATEGORY = "INSERT INTO category (name) VALUES (?)";
    private static final String READ_CATEGORY_BY_ID = "SELECT id, name FROM category WHERE id = ?";
    private static final String UPDATE_CATEGORY = "UPDATE category SET name = ? WHERE id = ?";
    private static final String DELETE_CATEGORY_BY_ID = "DELETE FROM category WHERE id = ?";
    private static final String READ_ALL_CATEGORIES = "SELECT id, name FROM category";

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
        Category category = new Category();
        ResultSet result = null;

        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_CATEGORY_BY_ID);){

            statement.setInt(1, id);
            result = statement.executeQuery();
            if(result.next()) {
                category.setId(result.getInt("id"));
                category.setName(result.getString("name"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }finally {
            if(result!=null) {
                try {
                    result.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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
                category.setId(resultSet.getInt("id"));
                category.setName(resultSet.getString("name"));
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
