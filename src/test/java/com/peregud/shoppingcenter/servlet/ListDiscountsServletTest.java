package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.ServletService;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

class ListDiscountsServletTest extends MockInit {
    ServletService<Discount> servletDiscountService = new ServletService<>();

    @Test
    void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/discounts-list.jsp"));

        new ListDiscountsServlet().doGet(request, response);
        verify(requestDispatcher).forward(request, response);

        List<?> listDiscounts = servletDiscountService.getList(Discount.class);
        verify(request).setAttribute(ATTR_LIST_DISCOUNTS, listDiscounts);
    }

    @Test
    void doPost() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/discounts-list.jsp"));

        when(request.getParameterValues(PARAM_DELETE_DISCOUNT)).thenReturn(new String[]{});

        new ListDiscountsServlet().doPost(request, response);
        verify(requestDispatcher).forward(request, response);

        List<?> listDiscounts = servletDiscountService.getList(Discount.class);
        verify(request).setAttribute(ATTR_LIST_DISCOUNTS, listDiscounts);
        verify(request, atLeast(1)).getParameterValues(PARAM_DELETE_DISCOUNT);
    }
}
