package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.MockInit;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.DiscountCommandService;
import com.peregud.shoppingcenter.service.impl.DiscountCommandServiceImpl;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class InfoDiscountCommandTest extends MockInit {
    DiscountCommandService discountCommandService = new DiscountCommandServiceImpl();

    @Test
    void execute() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/discount-information.jsp"));

        String id = "1";
        when(request.getParameter(any(String.class))).thenReturn(id);
        assertEquals(id, request.getParameter(PARAM_ID));

        new InfoDiscountCommand().execute(request, response);
        verify(requestDispatcher).forward(request, response);

        Discount discount = discountCommandService.getById(Discount.class, Integer.parseInt(id));
        verify(request).setAttribute(ATTR_DISCOUNT, discount);

        verify(request, atLeast(1)).getParameter(PARAM_ID);
    }
}
