package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.ServletService;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

class EditDiscountServletTest extends MockInit {
    ServletService<Discount> servletDiscountService = new ServletService<>();

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/discount-form.jsp"));

        when(request.getParameter(PARAM_ID)).thenReturn("1");
        assertEquals("1", request.getParameter(PARAM_ID));

        new EditDiscountServlet().doGet(request, response);
        verify(request, atLeast(1)).getParameter(PARAM_ID);

        Discount discount = servletDiscountService.getById(Discount.class, 1);
        verify(request).setAttribute(ATTR_DISCOUNT, discount);
    }
}
