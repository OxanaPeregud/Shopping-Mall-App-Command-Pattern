package com.peregud.shoppingcenter.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebFilter(filterName = "SessionLocaleFilter", urlPatterns = {"/*"})
public class SessionLocaleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if (req.getParameter(PARAM_LOCALE) != null) {
            req.getSession().setAttribute(ATTR_LANG, req.getParameter(PARAM_LOCALE));
        }
        chain.doFilter(request, response);
    }
}
