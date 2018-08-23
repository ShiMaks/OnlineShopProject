package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.service.ProductService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ADMIN;
import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.RequestParamValidator.validatePositiveInt;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_PRODUCT_ID;

public class DeleteProductAdminCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        String idProduct = request.getParameter(REQUEST_PARAM_PRODUCT_ID);
        if(validatePositiveInt(idProduct)) {
            productService.deleteProduct(Integer.parseInt(idProduct));
            return PAGE_ADMIN;
        } else {
            return PAGE_ERROR;
        }
    }
}
