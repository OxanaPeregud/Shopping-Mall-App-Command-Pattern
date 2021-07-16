package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.MockInit;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class AdminLoginCommandTest extends MockInit {

    @Test
    void execute() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/admin-login.jsp"));

        new AdminLoginCommand().execute(request, response);
        verify(requestDispatcher).forward(request, response);
    }
}