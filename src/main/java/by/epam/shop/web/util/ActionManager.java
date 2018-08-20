package by.epam.shop.web.util;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.commands.impl.admin.*;

import javax.servlet.http.HttpServletRequest;

public class ActionManager {

    private ActionManager(){
        throw new IllegalStateException("Utility class");
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        BaseCommand command = null;
        String inputCommand =  request.getParameter("command");
        switch(inputCommand) {
            case "start_page":
                command = new PreparationAdminPageCommandImpl();
                break;
            case "to_products":
                command = new PreparationProductsAdminCommandImpl();
                break;
            case "to_orders":
                command = null;
                break;
            case "to_categories":
                command = new PreparationCategoriesAdminCommandImpl();
                break;
            case "prepare_create_category":
                command = new PreparationCreateCategoryAdminImpl();
                break;
            case "create_category":
                command = new AddCategoryCommandImpl();
                break;
            case "delete_category":
                command = new DeleteCategoryAdminCommandImpl();
                break;
            case "prepare_update_category":
                command = new PreparationUpdateCategoryAdminCommandImpl();
                break;
            case "update_category":
                command = new UpdateCategoryAdminCommandImpl();
                break;
            default:
                //command = new StartPageCommandImpl();
                break;
        }
        return command;
    }
}
