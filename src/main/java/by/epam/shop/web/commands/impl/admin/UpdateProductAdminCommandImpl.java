package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Product;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import by.epam.shop.web.exception.ValidateNullRequestParamException;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.PagePathConstant.PAGE_UPDATE_PRODUCT;
import static by.epam.shop.web.util.PagePathConstant.REDIRECT_ADMIN_URL;
import static by.epam.shop.web.util.RequestParamValidator.*;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class UpdateProductAdminCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idProduct = request.getParameter(REQUEST_PARAM_PRODUCT_ID);
        String idCategory = request.getParameter(REQUEST_PARAM_CATEGORY_ID);
        if(!validatePositiveInt(idCategory) | !validatePositiveInt(idProduct)){
            return PAGE_ERROR;
        }
        if(validateProductInputData(request)) {
            Product product = createProduct(getRequestProductParamsMap(request));
            productService.addProductToShop(product);
            productService.updateProductInfo(product);
            request.getSession().setAttribute(SESSION_PAGE_TYPE, PAGE_TYPE_ADMIN_PRODUCT);
            request.getSession().setAttribute(REQUEST_PARAM_MESSAGE, "Product successfully updated");
            return REDIRECT_ADMIN_URL;
        } else {
            return PAGE_UPDATE_PRODUCT;
        }
    }

    private boolean validateProductInputData(HttpServletRequest request) throws ValidateNullRequestParamException {
        boolean result = true;
        if (!validateProductNameOrCategory(request.getParameter(REQUEST_PARAM_PRODUCT_NAME))) {
            result = false;
            System.out.println("error name");
        } else {

        }
        if (!validatePositiveInt(request.getParameter(REQUEST_PARAM_QUANTITY))) {
            result = false;
            System.out.println("error quantity");
        } else {

        }
        if (!validatePrice(request.getParameter(REQUEST_PARAM_PRODUCT_PRICE))) {
            result = false;
        } else {

        }
        if (!validateImageLink(request.getParameter(REQUEST_PARAM_PRODUCT_PICTURE))) {
            result = false;
            System.out.println("error picture");
        } else {

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
