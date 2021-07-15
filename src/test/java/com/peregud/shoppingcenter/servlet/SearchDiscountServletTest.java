package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.util.CriteriaSearchUtil;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

class SearchDiscountServletTest extends MockInit {

    @Test
    void doPost() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/display-discounts.jsp"));

        String minimumDiscount = "5";
        when(request.getParameter(PARAM_MIN_DISCOUNT)).thenReturn(minimumDiscount);
        assertEquals(minimumDiscount, request.getParameter(PARAM_MIN_DISCOUNT));

        new SearchDiscountServlet().doPost(request, response);
        verify(requestDispatcher).forward(request, response);

        List<?> listDiscountShops = CriteriaSearchUtil.joinTablesMinimumDiscount(
                Integer.parseInt(request.getParameter(PARAM_MIN_DISCOUNT)));
        verify(request).setAttribute(ATTR_LIST_DISCOUNT_SHOPS, listDiscountShops);
        verify(request, atLeast(1)).getParameterValues(request.getParameter(PARAM_MIN_DISCOUNT));
    }
}
