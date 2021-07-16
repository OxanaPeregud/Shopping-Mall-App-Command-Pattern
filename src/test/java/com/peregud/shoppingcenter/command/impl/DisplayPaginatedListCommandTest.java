package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.MockInit;
import com.peregud.shoppingcenter.util.CriteriaSearchUtil;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DisplayPaginatedListCommandTest extends MockInit {

    @Test
    void execute() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/display-discount-shops.jsp"));

        String pageNumber = "1";
        String pageSize = "1";
        when(request.getParameter(any(String.class))).thenReturn(pageNumber);
        when(request.getParameter(any(String.class))).thenReturn(pageSize);
        assertEquals(pageNumber, request.getParameter(PARAM_PAGE_NUMBER));
        assertEquals(pageSize, request.getParameter(PARAM_PAGE_SIZE));

        new DisplayPaginatedListCommand().execute(request, response);
        verify(requestDispatcher).forward(request, response);

        List<?> listDiscountShops = CriteriaSearchUtil.paginatedList(
                Integer.parseInt(pageNumber), Integer.parseInt(pageSize));
        verify(request).setAttribute(ATTR_LIST_DISCOUNT_SHOPS, listDiscountShops);
        verify(request, atLeast(1)).getParameter(PARAM_PAGE_NUMBER);
        verify(request, atLeast(1)).getParameter(PARAM_PAGE_SIZE);
    }
}
