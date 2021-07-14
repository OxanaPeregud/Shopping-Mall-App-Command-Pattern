package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.util.CriteriaSearchUtil;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SearchShopServletTest extends MockInit {

    @Test
    void doPost() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/display-shops.jsp"));

        String search = "name1";
        when(request.getParameter("search")).thenReturn(search);
        assertEquals(search, request.getParameter("search"));

        new SearchShopServlet().doPost(request, response);
        verify(requestDispatcher).forward(request, response);

        List<?> listShops = CriteriaSearchUtil.shopKeywords(request.getParameter("search"));
        verify(request).setAttribute("listShops", listShops);
        verify(request, atLeast(1)).getParameterValues(request.getParameter("search"));
    }
}
