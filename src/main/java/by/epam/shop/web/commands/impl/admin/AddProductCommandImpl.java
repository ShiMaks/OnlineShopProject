package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Product;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import by.epam.shop.web.exception.ValidateNullRequestParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static by.epam.shop.web.util.PagePathConstant.PAGE_CREATE_PRODUCT;
import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_URL;
import static by.epam.shop.web.util.RequestParamValidator.*;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class AddProductCommandImpl implements BaseCommand {

    private static final Logger LOGGER = LogManager.getLogger(AddProductCommandImpl.class);

    private static final String MESSAGE_VALUE = "success_add_product";
    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idCategory = request.getParameter(REQUEST_PARAM_CATEGORY_ID);
        System.out.println(idCategory);
        if (!validatePositiveInt(idCategory)) {
            return PAGE_ERROR;
        }
        if(validateProductInputData(request)){
            Product product = createProduct(getRequestProductParamsMap(request));
            productService.addProductToShop(product);
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PRODUCT);
            request.getSession().setAttribute(REQUEST_PARAM_SESSION_MESSAGE, MESSAGE_VALUE);
            LOGGER.info("product {} added to database", product);
            return REDIRECT_ADMIN_URL;
        } else {
            return PAGE_CREATE_PRODUCT;
        }
    }

    private boolean validateProductInputData(HttpServletRequest request) throws ValidateNullRequestParamException {
        boolean result = true;
        if (!validateProductNameOrCategory(request.getParameter(REQUEST_PARAM_PRODUCT_NAME))) {
            LOGGER.error("An invalid product name has been entered.");
            request.setAttribute(REQUEST_PARAM_INVALID_PRODUCT_NAME, REQUEST_PARAM_INVALID_PRODUCT_NAME);
            result = false;
        }
        if (!validatePositiveInt(request.getParameter(REQUEST_PARAM_QUANTITY))) {
            LOGGER.error("An invalid product quantity has been entered.");
            request.setAttribute(REQUEST_PARAM_INVALID_QUANTITY, REQUEST_PARAM_INVALID_QUANTITY);
            result = false;
        }
        if (!validatePrice(request.getParameter(REQUEST_PARAM_PRODUCT_PRICE))) {
            LOGGER.error("An invalid product price has been entered.");
            request.setAttribute(REQUEST_PARAM_INVALID_PRODUCT_PRICE, REQUEST_PARAM_INVALID_PRODUCT_PRICE);
            result = false;
        }
        if (!validateImageLink(request.getParameter(REQUEST_PARAM_PRODUCT_PICTURE))) {
            LOGGER.error("An invalid picture path has been entered.");
            request.setAttribute(REQUEST_PARAM_INVALID_PICTURE_PATH, REQUEST_PARAM_INVALID_PICTURE_PATH);
            result = false;
        }
        return result;
    }

    private Product createProduct(Map<String, String> productParam){
        Product product  = new Product();
        product.setName(productParam.get(REQUEST_PARAM_PRODUCT_NAME));
        product.setDescription(productParam.get(REQUEST_PARAM_DESCRIPTION));
        product.setIdCategory(Integer.parseInt(productParam.get(REQUEST_PARAM_CATEGORY_ID)));
        product.setQuantity(Integer.parseInt(productParam.get(REQUEST_PARAM_QUANTITY)));
        product.setPrice(Integer.parseInt(productParam.get(REQUEST_PARAM_PRODUCT_PRICE)));
        product.setPicture(productParam.get(REQUEST_PARAM_PRODUCT_PICTURE));
        product.setInStock(true);
        return product;
    }

    private Map<String, String> getRequestProductParamsMap(HttpServletRequest request) {
        Map<String, String> requestParams = new HashMap<>();
        requestParams.put(REQUEST_PARAM_QUANTITY, request.getParameter(REQUEST_PARAM_QUANTITY));
        requestParams.put(REQUEST_PARAM_PRODUCT_PRICE, request.getParameter(REQUEST_PARAM_PRODUCT_PRICE));
        requestParams.put(REQUEST_PARAM_DESCRIPTION, request.getParameter(REQUEST_PARAM_DESCRIPTION));
        requestParams.put(REQUEST_PARAM_PRODUCT_NAME, request.getParameter(REQUEST_PARAM_PRODUCT_NAME));
        requestParams.put(REQUEST_PARAM_PRODUCT_PICTURE, request.getParameter(REQUEST_PARAM_PRODUCT_PICTURE));
        requestParams.put(REQUEST_PARAM_CATEGORY_ID, request.getParameter(REQUEST_PARAM_CATEGORY_ID));
        return requestParams;
    }
}
