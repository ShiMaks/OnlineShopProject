package by.epam.shop.dao.impl;

import by.epam.shop.dao.AbstractDao;
import by.epam.shop.dao.CategoryDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.pool.ConnectionPool;
import by.epam.shop.domain.Category;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.epam.shop.dao.util.TablesColumnNamesDeclaration.CATEGORY_COLUMN_ID;
import static by.epam.shop.dao.util.TablesColumnNamesDeclaration.CATEGORY_COLUMN_NAME;

/**
 * Class for working with the category table from database
 *
 * @author Shilvian Maksim
 */
public class CategoryDaoDBImpl extends AbstractDao<Category> implements CategoryDao {

    private static final Logger LOGGER = LogManager.getLogger(CategoryDaoDBImpl.class);

    /**
     * SQL-statements
     */
    private static final String CREATE_CATEGORY = "INSERT INTO category (name) VALUES (?)";
    private static final String READ_CATEGORY_BY_ID = "SELECT id, name FROM category WHERE id = ?";
    private static final String UPDATE_CATEGORY = "UPDATE category SET name = ? WHERE id = ?";
    private static final String DELETE_CATEGORY_BY_ID = "DELETE FROM category WHERE id = ?";
    private static final String READ_ALL_CATEGORIES = "SELECT id, name FROM category";

    public CategoryDaoDBImpl(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    protected Category mapRow(ResultSet resultSet) throws DaoException {
        Category category = new Category();
        try{
            category.setId(resultSet.getInt(CATEGORY_COLUMN_ID));
            category.setName(resultSet.getString(CATEGORY_COLUMN_NAME));
        } catch(SQLException e){
            throw new DaoException(e);
        }
        return category;
    }

    @Override
    public void create(Category entity) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_CATEGORY)){
            statement.setString(1, entity.getName());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    @Override
    public Category read(int id) throws DaoException {
        return read(id, READ_CATEGORY_BY_ID);
    }

    @Override
    public void update(Category entity) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_CATEGORY)){
            statement.setString(1, entity.getName());
            statement.setInt(2, entity.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        delete(id, DELETE_CATEGORY_BY_ID);
    }

    @Override
    public List<Category> readAll() throws DaoException {
        return readAll(READ_ALL_CATEGORIES);
    }
}
