package by.epam.shop.web.controller;

import by.epam.shop.web.commands.BaseCommand;
import by.epam.shop.web.exception.CommandException;
import by.epam.shop.web.util.ActionManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.epam.shop.web.util.PagePathConstant.*;


public class FrontController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        BaseCommand command = ActionManager.defineCommand(request);
        String path = null;
        try {
            path = command.executeCommand(request);
            if (path.equals(REDIRECT_ADMIN_PRODUCT_URL)) {
                response.sendRedirect(request.getContextPath() + REDIRECT_ADMIN_PRODUCT_URL);
            } else if (path.equals(REDIRECT_ADMIN_CATEGORY_URL)) {
                response.sendRedirect(request.getContextPath() + REDIRECT_ADMIN_CATEGORY_URL);
            } else if (path.equals(REDIRECT_ADMIN_ORDER_URL)) {
                response.sendRedirect(request.getContextPath() + REDIRECT_ADMIN_ORDER_URL);
            } else if (path.equals(REDIRECT_USER_URL)) {
                response.sendRedirect(request.getContextPath() + REDIRECT_USER_URL);
            } else if (path.equals(REDIRECT_GUEST_URL)) {
                response.sendRedirect(request.getContextPath() + REDIRECT_GUEST_URL);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher(path);
                dispatcher.forward(request, response);
            }
        } catch (CommandException e) {
            request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
        }
    }
}
