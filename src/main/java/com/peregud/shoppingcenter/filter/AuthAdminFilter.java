package com.peregud.shoppingcenter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebFilter(filterName = "AuthAdminFilter", urlPatterns = {"/controller?command=list_shops"})
public class AuthAdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String contextPath = req.getContextPath();
        HttpSession session = req.getSession();
        if ((session != null) && (session.getAttribute(ATTR_ADMIN) != null)) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(contextPath + "/view/admin-login.jsp");
        }
    }
}
