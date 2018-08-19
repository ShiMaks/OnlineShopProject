package by.epam.shop.web.util;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.commands.impl.admin.PreparationAdminPageCommandImpl;
import by.epam.shop.web.commands.impl.admin.PreparationCategoriesAdminCommandImpl;
import by.epam.shop.web.commands.impl.admin.PreparationProductsAdminCommandImpl;

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
            default:
                //command = new StartPageCommandImpl();
                break;
        }
        return command;
    }

}
