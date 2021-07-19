package com.peregud.shoppingcenter.filter;

import org.apache.commons.lang3.StringUtils;

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
        if (StringUtils.isNotBlank(req.getParameter(PARAM_LOCALE))) {
            req.getSession().setAttribute(ATTR_LANG, req.getParameter(PARAM_LOCALE));
        }
        chain.doFilter(request, response);
    }
}
