package by.epam.shop.web.commands.impl.user;

import by.epam.shop.domain.Product;
import by.epam.shop.domain.ShopCart;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_CART;
import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_PRODUCT_ID;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_SHOPPING_CART;

public class DeleteProductFromCartCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idProduct = request.getParameter(REQUEST_PARAM_PRODUCT_ID);
        if(validatePositiveInt(idProduct)){
            Product product = productService.getProduct(Integer.parseInt(idProduct));
            ShopCart shopCart = (ShopCart) request.getSession().getAttribute(REQUEST_PARAM_SHOPPING_CART);
            shopCart.removeProduct(product);
            request.getSession().setAttribute(REQUEST_PARAM_SHOPPING_CART, shopCart);
            return PAGE_CART;
        } else {
            return PAGE_ERROR;
        }
    }
}
