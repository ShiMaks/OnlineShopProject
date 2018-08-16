package by.epam.shop.web.commands;

import by.epam.shop.web.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface BaseCommand {

    String executeCommand (HttpServletRequest request) throws CommandException;
}
