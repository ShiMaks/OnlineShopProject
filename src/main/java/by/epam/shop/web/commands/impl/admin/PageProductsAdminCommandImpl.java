package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.domain.Product;
import by.epam.shop.service.ProductService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static by.epam.shop.web.util.PagePathConstant.PAGE_PRODUCTS_ADMIN;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_LIST_PRODUCTS_ADMIN;

public class PageProductsAdminCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        List<Product> products;
        products = productService.getProducts();
        request.setAttribute(REQUEST_PARAM_LIST_PRODUCTS_ADMIN, products);
        return PAGE_PRODUCTS_ADMIN;
    }
}
