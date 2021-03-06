package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Category;
import by.epam.shop.domain.Product;
import by.epam.shop.service.CategoryService;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import by.epam.shop.web.exception.ValidateNullRequestParamException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.PAGE_UPDATE_PRODUCT;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_URL;
import static by.epam.shop.web.util.RequestParamValidator.*;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class UpdateProductAdminCommandImpl implements BaseCommand {

    private static final Logger LOGGER = LogManager.getLogger(UpdateProductAdminCommandImpl.class);

    private static final String MESSAGE_VALUE = "success_update_product";
    private ProductService productService = ServiceFactory.getProductService();
    private CategoryService categoryService = ServiceFactory.getCategoryService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idProduct = request.getParameter(REQUEST_PARAM_PRODUCT_ID);
        String idCategory = request.getParameter(REQUEST_PARAM_CATEGORY_ID);
        if(!validatePositiveInt(idCategory) | !validatePositiveInt(idProduct)){
            return PAGE_ERROR;
        }
        if(validateProductInputData(request)) {
            Product product = createProduct(getRequestProductParamsMap(request));
            productService.updateProductInfo(product);
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PRODUCT);
            request.getSession().setAttribute(REQUEST_PARAM_SESSION_MESSAGE, MESSAGE_VALUE);
            LOGGER.info("product id={} update product:{}",idProduct, product);
            return REDIRECT_ADMIN_URL;
        } else {
            Product product = productService.getProduct(Integer.parseInt(idProduct));
            Category category = categoryService.getCategory(product.getIdCategory());
            List<Category> categories = categoryService.getCategories();
            request.setAttribute(REQUEST_PARAM_PRODUCT, product);
            request.setAttribute(REQUEST_PARAM_LIST_CATEGORIES_ADMIN, categories);
            request.setAttribute(REQUEST_PARAM_CATEGORY, category);
            return PAGE_UPDATE_PRODUCT;
        }
    }

    private boolean validateProductInputData(HttpServletRequest request) throws ValidateNullRequestParamException {
        boolean result = true;
        if (!validateProductNameOrCategory(request.getParameter(REQUEST_PARAM_PRODUCT_NAME))) {
            LOGGER.error("An invalid product name has been entered.Name: {}",
                    request.getParameter(REQUEST_PARAM_PRODUCT_NAME));
            request.setAttribute(REQUEST_PARAM_INVALID_PRODUCT_NAME, REQUEST_PARAM_INVALID_PRODUCT_NAME);
            result = false;
        }
        if (!validatePositiveInt(request.getParameter(REQUEST_PARAM_QUANTITY))) {
            LOGGER.error("An invalid product quantity has been entered. Quantity: {}",
                    request.getParameter(REQUEST_PARAM_QUANTITY));
            request.setAttribute(REQUEST_PARAM_INVALID_QUANTITY, REQUEST_PARAM_INVALID_QUANTITY);
            result = false;
        }
        if (!validatePrice(request.getParameter(REQUEST_PARAM_PRODUCT_PRICE))) {
            LOGGER.error("An invalid product price has been entered. Price: {}",
                    request.getParameter(REQUEST_PARAM_PRODUCT_PRICE));
            request.setAttribute(REQUEST_PARAM_INVALID_PRODUCT_PRICE, REQUEST_PARAM_INVALID_PRODUCT_PRICE);
            result = false;
        }
        if (!validateImageLink(request.getParameter(REQUEST_PARAM_PRODUCT_PICTURE))) {
            LOGGER.error("An invalid picture path has been entered. Picture path: {}",
                    request.getParameter(REQUEST_PARAM_PRODUCT_PICTURE));
            request.setAttribute(REQUEST_PARAM_INVALID_PICTURE_PATH, REQUEST_PARAM_INVALID_PICTURE_PATH);
            result = false;
        } else {
            LOGGER.info("Validation of the entered product data was successful.");
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
        product.setId(Integer.parseInt(productParam.get(REQUEST_PARAM_PRODUCT_ID)));
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
        requestParams.put(REQUEST_PARAM_PRODUCT_ID, request.getParameter(REQUEST_PARAM_PRODUCT_ID));
        return requestParams;
    }
}
