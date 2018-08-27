package by.epam.shop.web.filter;

import by.epam.shop.domain.User;
import by.epam.shop.domain.UserRoleEnum;
import by.epam.shop.web.util.SecurityManager;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static by.epam.shop.web.util.PagePathConstant.PAGE_ERROR;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_COMMAND;
import static by.epam.shop.web.util.WebConstantDeclaration.REQUEST_PARAM_USER;

public class AuthFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpSession session = req.getSession(true);

        User currentUser = (User) session.getAttribute(REQUEST_PARAM_USER);
        String inputCommand = request.getParameter(REQUEST_PARAM_COMMAND);

        if (inputCommand != null && !inputCommand.isEmpty()) {
            SecurityManager security = new SecurityManager();

            if (currentUser != null) {
                if (currentUser.isAdmin() && security.getRoles(inputCommand) == UserRoleEnum.ADMIN) {
                    chain.doFilter(request, response);
                } else if (!currentUser.isAdmin() && security.getRoles(inputCommand) == UserRoleEnum.USER) {
                    chain.doFilter(request, response);
                } else if (security.getRoles(inputCommand) == UserRoleEnum.ALL) {
                    chain.doFilter(request, response);
                } else {
                    request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
                }
            } else {
                if (security.getRoles(inputCommand) == UserRoleEnum.ALL) {
                    chain.doFilter(request, response);
                } else {
                    //session.setAttribute("message", "You need to register");
                    request.getRequestDispatcher(PAGE_ERROR).forward(request, response);
                }
            }
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
