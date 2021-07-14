package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.ServletService;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

class InfoDiscountServletTest extends MockInit {
    ServletService<Discount> servletDiscountService = new ServletService<>();

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/discount-information.jsp"));

        when(request.getParameter("id")).thenReturn("1");
        assertEquals("1", request.getParameter("id"));

        new InfoDiscountServlet().doGet(request, response);
        verify(request, atLeast(1)).getParameter("id");

        Discount discount = servletDiscountService.getById(Discount.class, 1);
        verify(request).setAttribute("discount", discount);
    }
}
