package by.epam.shop.service;

import by.epam.shop.domain.Product;
import by.epam.shop.service.exception.ServiceException;

import java.util.List;

public interface ProductService {

    void addProductToShop(Product product) throws ServiceException;

    void updateProductInfo(Product product) throws  ServiceException;

    void deleteProduct(int id) throws ServiceException;

    Product getProduct(int id) throws ServiceException;

    List<Product>  getProducts() throws ServiceException;

    List<Product> getProductsByCategory(int idCategory);
}
