package by.epam.shop.web.commands.impl.all;

import by.epam.shop.service.ProductService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_CART;
import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;

public class AddProductToCartCommandImpl implements BaseCommand{

    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idProduct = request.getParameter("product_id");
        if(validatePositiveInt(idProduct)){
            //execute for the session
            return PAGE_CART;
        } else {
            return PAGE_ERROR;
        }
    }
}
