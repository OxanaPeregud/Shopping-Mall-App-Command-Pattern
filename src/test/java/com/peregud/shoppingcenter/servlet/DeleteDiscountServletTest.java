package com.peregud.shoppingcenter.servlet;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

class DeleteDiscountServletTest extends MockInit {

    @Test
    void doGet() throws IOException {
        when(request.getParameter(PARAM_ID)).thenReturn("1");
        assertEquals("1", request.getParameter(PARAM_ID));

        new DeleteDiscountServlet().doGet(request, response);
        verify(request, atLeast(1)).getParameter(PARAM_ID);
    }
}
