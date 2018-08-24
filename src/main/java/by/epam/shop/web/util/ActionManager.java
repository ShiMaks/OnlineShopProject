package by.epam.shop.web.util;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.commands.impl.admin.*;
import by.epam.shop.web.commands.impl.all.AddProductToCartCommandImpl;
import by.epam.shop.web.commands.impl.all.DisplayCategoryProdCommandImpl;
import by.epam.shop.web.commands.impl.all.DisplayingProductInfoCommandImpl;
import by.epam.shop.web.commands.impl.all.StartPageCommandImpl;

import javax.servlet.http.HttpServletRequest;

import static by.epam.shop.web.util.CommandDeclaration.*;

public class ActionManager {

    private ActionManager(){
        throw new IllegalStateException("Utility class");
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        BaseCommand command = null;
        String inputCommand =  request.getParameter("command");
        switch(inputCommand) {
            case "start_page":
                command = new StartPageCommandImpl();
                break;
//            case "start_page":
//                command = new PreparationAdminPageCommandImpl();
//                break;
            case COMMAND_TO_PRODUCTS:
                command = new PreparationProductsAdminCommandImpl();
                break;
            case COMMAND_TO_ORDERS:
                command = null;
                break;
            case COMMAND_TO_CATEGORIES:
                command = new PreparationCategoriesAdminCommandImpl();
                break;
            case COMMAND_PREPARE_CREATE_CATEGORY:
                command = new PreparationCreateCategoryAdminImpl();
                break;
            case COMMAND_CREATE_CATEGORY:
                command = new AddCategoryCommandImpl();
                break;
            case COMMAND_DELETE_CATEGORY:
                command = new DeleteCategoryAdminCommandImpl();
                break;
            case COMMAND_PREPARE_UPDATE_CATEGORY:
                command = new PreparationUpdateCategoryAdminCommandImpl();
                break;
            case COMMAND_UPDATE_CATEGORY:
                command = new UpdateCategoryAdminCommandImpl();
                break;
            case COMMAND_DELETE_PRODUCT:
                command = new DeleteProductAdminCommandImpl();
                break;
            case COMMAND_PREPARE_UPDATE_PRODUCT:
                command = new PreparationUpdateProductAdminCommandImpl();
                break;
            case "show_products_category":
                command = new DisplayCategoryProdCommandImpl();
                break;
            case "show_products_info":
                command = new DisplayingProductInfoCommandImpl();
                break;
            case "add_product_to_cart":
               command = new AddProductToCartCommandImpl();
               break;
            default:
                //command = new StartPageCommandImpl();
                break;
        }
        return command;
    }
}
