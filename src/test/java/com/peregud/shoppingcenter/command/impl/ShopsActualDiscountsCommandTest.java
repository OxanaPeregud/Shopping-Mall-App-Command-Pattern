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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ShopsActualDiscountsCommandTest extends MockInit {

    @Test
    void execute() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/display-discount-shops.jsp"));

        new ShopsActualDiscountsCommand().execute(request, response);
        verify(requestDispatcher).forward(request, response);

        List<?> listActualDiscounts = CriteriaSearchUtil.joinTablesActualDiscounts();
        verify(request).setAttribute(ATTR_LIST_DISCOUNT_SHOPS, listActualDiscounts);
    }
}
