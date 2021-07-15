package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletService;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

class InfoShopServletTest extends MockInit {
    ServletService<Shop> servletShopService = new ServletService<>();

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/shop-information.jsp"));

        when(request.getParameter(PARAM_ID)).thenReturn("1");
        assertEquals("1", request.getParameter(PARAM_ID));

        new InfoShopServlet().doGet(request, response);
        verify(request, atLeast(1)).getParameter(PARAM_ID);

        Shop shop = servletShopService.getById(Shop.class, 1);
        verify(request).setAttribute(ATTR_SHOP, shop);
    }
}
