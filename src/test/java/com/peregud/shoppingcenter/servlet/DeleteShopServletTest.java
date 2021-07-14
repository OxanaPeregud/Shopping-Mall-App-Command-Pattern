package com.peregud.shoppingcenter.servlet;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class DeleteShopServletTest extends MockInit {

    @Test
    void doGet() throws IOException {
        when(request.getParameter("id")).thenReturn("1");
        assertEquals("1", request.getParameter("id"));

        new DeleteShopServlet().doGet(request, response);
        verify(request, atLeast(1)).getParameter("id");
    }
}
