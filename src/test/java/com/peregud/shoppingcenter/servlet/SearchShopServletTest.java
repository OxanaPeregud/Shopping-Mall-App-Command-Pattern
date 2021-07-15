package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.util.CriteriaSearchUtil;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

class SearchShopServletTest extends MockInit {

    @Test
    void doPost() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/display-shops.jsp"));

        String search = "name1";
        when(request.getParameter(PARAM_SEARCH)).thenReturn(search);
        assertEquals(search, request.getParameter(PARAM_SEARCH));

        new SearchShopServlet().doPost(request, response);
        verify(requestDispatcher).forward(request, response);

        List<?> listShops = CriteriaSearchUtil.shopKeywords(request.getParameter(PARAM_SEARCH));
        verify(request).setAttribute(ATTR_LIST_SHOPS, listShops);
        verify(request, atLeast(1)).getParameterValues(request.getParameter(PARAM_SEARCH));
    }
}
