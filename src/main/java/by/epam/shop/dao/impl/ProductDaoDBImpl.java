package by.epam.shop.dao.impl;

import by.epam.shop.dao.AbstractDao;
import by.epam.shop.dao.ProductDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for working with the product table from database
 *
 * @author Shilvian Maksim
 */
public class ProductDaoDBImpl extends AbstractDao implements ProductDao {

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
            " FROM product LIMIT ?, 9";

    @Override
    public void create(Product product) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_PRODUCT);){
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
        }
    }

    @Override
    public Product read(int id) throws DaoException {
        Product product = new Product();
        ResultSet result = null;
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_PRODUCT_BY_ID);){

            statement.setInt(1, id);
            result = statement.executeQuery();

            if(result.next()) {
                product.setId(result.getInt("id"));
                product.setName(result.getString("name"));
                product.setIdCategory(result.getInt("category_id"));
                product.setPrice(result.getInt("price"));
                product.setPicture(result.getString("picture"));
                product.setDescription(result.getString("description"));
                product.setQuantity(result.getInt("quantity"));
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
        return product;
    }

    @Override
    public void update(Product product) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT);){
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
        }
    }

    @Override
    public void delete(int id) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Product> readAll() throws DaoException {
        List<Product> products = new ArrayList<>();
        ResultSet resultSet = null;

        try (Connection connection = connect.getConnection(); Statement statement = connection.createStatement();) {

            resultSet = statement.executeQuery(READ_ALL_PRODUCTS);
            while(resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setIdCategory(resultSet.getInt("category_id"));
                product.setPrice(resultSet.getInt("price"));
                product.setPicture(resultSet.getString("picture"));
                product.setQuantity(resultSet.getInt("quantity"));
                products.add(product);
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
        return products;
    }

    @Override
    public List<Product> getProductsByCategory(int id) throws DaoException {
        List<Product> products = new ArrayList<>();
        ResultSet resultSet = null;

        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_PRODUCTS_BY_CATEGORY);){

            statement.setInt(1, id);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setIdCategory(resultSet.getInt("category_id"));
                product.setPrice(resultSet.getInt("price"));
                product.setPicture(resultSet.getString("picture"));
                product.setQuantity(resultSet.getInt("quantity"));
                products.add(product);
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
        return products;
    }

    @Override
    public List<Product> getProductsForPage(int startPosition) throws DaoException {
        List<Product> products = new ArrayList<>();
        ResultSet resultSet = null;

        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_PRODUCTS_FOR_PAGE);){

            statement.setInt(1, startPosition);
            resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("description"));
                product.setIdCategory(resultSet.getInt("category_id"));
                product.setPrice(resultSet.getInt("price"));
                product.setPicture(resultSet.getString("picture"));
                product.setQuantity(resultSet.getInt("quantity"));
                products.add(product);
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
        return products;
    }
}
