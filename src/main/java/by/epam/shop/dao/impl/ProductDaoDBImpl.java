package by.epam.shop.dao.impl;

import by.epam.shop.dao.AbstractDao;
import by.epam.shop.dao.ProductDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.dao.pool.ConnectionPool;
import by.epam.shop.domain.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.epam.shop.dao.util.TablesColumnNamesDeclaration.*;

/**
 * Class for working with the product table from database
 *
 * @author Shilvian Maksim
 */
public class ProductDaoDBImpl extends AbstractDao<Product> implements ProductDao {

    private static final Logger LOGGER = LogManager.getLogger(ProductDaoDBImpl.class);

    /**
     * SQL-statements
     */
    private static final String CREATE_PRODUCT = "INSERT INTO product (name, category_id, description, inStock, price, picture, quantity)" +
            " VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String READ_PRODUCT_BY_ID = "SELECT id, name, category_id, description, inStock, price, picture, quantity " +
            "FROM product WHERE id = ?";
    private static final String UPDATE_PRODUCT = "UPDATE product SET name = ?, category_id = ?, description = ?, inStock = ?," +
            " price = ?, picture = ?  WHERE id = ?";
    private static final String DELETE_PRODUCT_BY_ID = "DELETE FROM product WHERE id = ?";
    private static final String READ_ALL_PRODUCTS = "SELECT id, name, category_id, description, inStock, price, picture, quantity " +
            "FROM product";
    private static final String READ_PRODUCTS_BY_CATEGORY = "SELECT id, name, category_id, description, inStock, price, picture, quantity " +
            "FROM product WHERE category_id = ?";
    private static final String READ_PRODUCTS_FOR_PAGE = "SELECT id, name, category_id, description, inStock, price, picture, quantity " +
            " FROM product LIMIT ?, 5";

    public ProductDaoDBImpl(ConnectionPool connectionPool) {
        super(connectionPool);
    }

    @Override
    protected Product mapRow(ResultSet resultSet) throws DaoException {
        Product product = new Product();
        try{
            product.setId(resultSet.getInt(PRODUCT_COLUMN_ID));
            product.setName(resultSet.getString(PRODUCT_COLUMN_NAME));
            product.setDescription(resultSet.getString(PRODUCT_COLUMN_DESCRIPTION));
            product.setIdCategory(resultSet.getInt(PRODUCT_COLUMN_CATEGORY_ID));
            product.setPrice(resultSet.getInt(PRODUCT_COLUMN_PRICE));
            product.setPicture(resultSet.getString(PRODUCT_COLUMN_PICTURE));
            product.setQuantity(resultSet.getInt(PRODUCT_COLUMN_QUANTITY));
        } catch(SQLException e){
            throw new DaoException(e);
        }
        return product;
    }

    @Override
    public void create(Product product) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(CREATE_PRODUCT)){
            statement.setString(1, product.getName());
            statement.setInt(2, product.getIdCategory());
            statement.setString(3, product.getDescription());
            statement.setBoolean(4, product.isInStock());
            statement.setInt(5, product.getPrice());
            statement.setString(6, product.getPicture());
            statement.setInt(7, product.getQuantity());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    @Override
    public Product read(int id) throws DaoException {
        return read(id, READ_PRODUCT_BY_ID);
    }

    @Override
    public void update(Product product) throws DaoException {
        Connection connection = dataBaseConnection.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT)){
            statement.setString(1, product.getName());
            statement.setInt(2, product.getIdCategory());
            statement.setString(3, product.getDescription());
            statement.setBoolean(4, product.isInStock());
            statement.setInt(5, product.getPrice());
            statement.setString(6, product.getPicture());
            statement.setInt(7, product.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        } finally {
            dataBaseConnection.returnConnection(connection);
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        delete(id, DELETE_PRODUCT_BY_ID);
    }

    @Override
    public List<Product> readAll() throws DaoException {
        return readAll(READ_ALL_PRODUCTS);
    }

    @Override
    public List<Product> getProductsByCategory(int id) throws DaoException {
        return readAllByCondition(id, READ_PRODUCTS_BY_CATEGORY);
    }

    @Override
    public List<Product> getProductsForPage(int startPosition) throws DaoException {
        return readAllByCondition(startPosition, READ_PRODUCTS_FOR_PAGE);
    }
}
