package by.epam.shop.dao.impl;

import by.epam.shop.dao.AbstractDao;
import by.epam.shop.dao.ProductDao;
import by.epam.shop.dao.exception.DaoException;
import by.epam.shop.domain.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoDBImpl extends AbstractDao implements ProductDao {

    private static final String CREATE_PRODUCT = "";
    private static final String READ_PRODUCT_BY_ID = "";
    private static final String UPDATE_PRODUCT = "";
    private static final String DELETE_PRODUCT_BY_ID = "";
    private static final String READ_ALL_PRODUCTS = "";

    @Override
    public void create(Product product) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_PRODUCT);){
            statement.setString(1, product.getName());
            statement.setInt(2, product.getIdCategory());
            statement.setString(3, product.getDescription());
            statement.setBoolean(3, product.isInStock());
            statement.setInt(3, product.getPrice());
            statement.setString(3, product.getPicture());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Product read(int id) throws DaoException {
        Product product = null;
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_PRODUCT_BY_ID);
             ResultSet result = statement.executeQuery();){

            statement.setInt(1, id);

            if(result.next()) {
                product.setId(result.getInt("ID"));
                product.setName(result.getString("NAME"));
                product.setIdCategory(result.getInt("ID_CATEGORY"));
                product.setPrice(result.getInt("PRICE"));
                product.setPicture(result.getString("PICTURE"));
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }
        return product;
    }

    @Override
    public void update(Product product) throws DaoException {
        try (Connection connection = connect.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT);){
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setInt(2, product.getIdCategory());
            statement.setString(2, product.getPicture());
            statement.setInt(2, product.getId());
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
                product.setName(resultSet.getString("Name"));
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
