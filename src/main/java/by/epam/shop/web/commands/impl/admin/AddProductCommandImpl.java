package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Product;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_PRODUCT_URL;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class AddProductCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        //execute parameter check
        int idCategory = Integer.parseInt(request.getParameter(REQUEST_PARAM_CATEGORY_ID));
        int quantity = Integer.parseInt(request.getParameter(REQUEST_PARAM_QUANTITY));
        int price = Integer.parseInt((request.getParameter(REQUEST_PARAM_PRODUCT_PRICE)));
        String description = request.getParameter(REQUEST_PARAM_DESCRIPTION);
        String nameProduct = request.getParameter(REQUEST_PARAM_PRODUCT_NAME);
        String picture = request.getParameter(REQUEST_PARAM_PRODUCT_PICTURE);

        Product product  = new Product();
        product.setName(nameProduct);
        product.setIdCategory(idCategory);
        product.setDescription(description);
        product.setQuantity(quantity);
        product.setPrice(price);
        product.setPicture(picture);

        productService.addProductToShop(product);
        return REDIRECT_ADMIN_PRODUCT_URL;
    }
}
