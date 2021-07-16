package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.MockInit;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ShopCommandService;
import com.peregud.shoppingcenter.service.impl.ShopCommandServiceImpl;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class DeleteListShopsCommandTest extends MockInit {
    ShopCommandService shopCommandService = new ShopCommandServiceImpl();

    @Test
    void execute() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/shops-list.jsp"));

        String[] idList = new String[]{};
        when(request.getParameterValues(any(String.class))).thenReturn(idList);
        assertEquals(idList, request.getParameterValues(PARAM_DELETE_SHOP));

        new DeleteListShopsCommand().execute(request, response);
        verify(requestDispatcher).forward(request, response);

        List<?> listShops = shopCommandService.getList(Shop.class);
        verify(request).setAttribute(ATTR_LIST_SHOPS, listShops);
        verify(request, atLeast(1)).getParameterValues(PARAM_DELETE_SHOP);
    }
}