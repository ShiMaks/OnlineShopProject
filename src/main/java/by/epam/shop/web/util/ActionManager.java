package by.epam.shop.web.util;

import by.epam.shop.web.commands.BaseCommand;

import javax.servlet.http.HttpServletRequest;

public class ActionManager {

    private ActionManager(){
        throw new IllegalStateException("Utility class");
    }

    public static BaseCommand defineCommand(HttpServletRequest request) {
        BaseCommand command = null;
        return command;
    }

}
