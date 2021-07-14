package com.peregud.shoppingcenter.servlet;

import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ShopsActualDiscountsServletTest extends MockInit {

    @Test
    void doPost() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/display-discount-shops.jsp"));

        new ShopsActualDiscountsServlet().doPost(request, response);
        verify(requestDispatcher).forward(request, response);
    }
}
