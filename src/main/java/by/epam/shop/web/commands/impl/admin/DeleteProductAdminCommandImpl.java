package by.epam.shop.web.commands.impl.admin;

import by.epam.shop.service.ProductService;
import by.epam.shop.service.exception.ServiceException;
import by.epam.shop.service.factory.ServiceFactory;
import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public class DeleteProductAdminCommandImpl implements BaseCommand {

    private ProductService productService = ServiceFactory.getProductService();

    @Override
    public String executeCommand(HttpServletRequest request) throws CommandException {
        //execute parameter check
        int idProduct = Integer.parseInt(request.getParameter("product_id"));

        try {
            productService.deleteProduct(idProduct);
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return null;
    }
}
