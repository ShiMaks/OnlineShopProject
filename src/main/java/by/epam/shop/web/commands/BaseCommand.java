package by.epam.shop.web.commands;

import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface BaseCommand {

    String executeCommand (HttpServletRequest request) throws CommandException;
}
