package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletService;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class DisplayAllShopsServletTest extends MockInit {
    ServletService<Shop> servletShopService = new ServletService<>();

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/display-shops.jsp"));

        new DisplayAllShopsServlet().doGet(request, response);
        verify(requestDispatcher).forward(request, response);

        List<?> listShops = servletShopService.getList(Shop.class);
        verify(request).setAttribute("listShops", listShops);
    }
}
