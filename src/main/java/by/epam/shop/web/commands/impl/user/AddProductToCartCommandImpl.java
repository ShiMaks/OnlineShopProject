package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.Product;
import by.epam.shop.domain.ShopCart;
import by.epam.shop.domain.User;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_CART;
import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.*;

public class AddProductToCartCommandImpl implements BaseCommand{

    private static final Logger LOGGER = LogManager.getLogger(AddProductToCartCommandImpl.class);

    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idProduct = request.getParameter(REQUEST_PARAM_PRODUCT_ID);
        String quantity = request.getParameter(REQUEST_PARAM_QUANTITY);
        if(validatePositiveInt(quantity)){
            Product product = productService.getProduct(Integer.parseInt(idProduct));
            ShopCart cart = (ShopCart) request.getSession().getAttribute(REQUEST_PARAM_SHOPPING_CART);
            cart.addProduct(product, Integer.parseInt(quantity));
            request.getSession().setAttribute(REQUEST_PARAM_SHOPPING_CART, cart);

            User user = (User) request.getSession().getAttribute(REQUEST_PARAM_USER);
            LOGGER.info("user login={} added product {} to cart", user.getLogin(), product);
            return PAGE_CART;
        } else {
            return PAGE_ERROR;
        }
    }
}
