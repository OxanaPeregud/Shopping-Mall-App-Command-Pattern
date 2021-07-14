package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletService;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class InfoShopServletTest extends MockInit {
    ServletService<Shop> servletShopService = new ServletService<>();

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/shop-information.jsp"));

        when(request.getParameter("id")).thenReturn("1");
        assertEquals("1", request.getParameter("id"));

        new InfoShopServlet().doGet(request, response);
        verify(request, atLeast(1)).getParameter("id");

        Shop shop = servletShopService.getById(Shop.class, 1);
        verify(request).setAttribute("shop", shop);
    }
}
