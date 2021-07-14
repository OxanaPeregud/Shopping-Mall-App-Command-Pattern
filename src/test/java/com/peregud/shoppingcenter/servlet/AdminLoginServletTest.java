package com.peregud.shoppingcenter.servlet;

import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AdminLoginServletTest extends MockInit {

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/admin-login.jsp"));

        new AdminLoginServlet().doGet(request, response);
        verify(requestDispatcher).forward(request, response);
    }
}
