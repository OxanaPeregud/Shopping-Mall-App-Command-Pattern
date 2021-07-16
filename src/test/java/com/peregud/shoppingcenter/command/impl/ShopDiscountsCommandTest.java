package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.MockInit;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ShopCommandService;
import com.peregud.shoppingcenter.service.impl.ShopCommandServiceImpl;
import com.peregud.shoppingcenter.util.CriteriaSearchUtil;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ShopDiscountsCommandTest extends MockInit {
    ShopCommandService shopCommandService = new ShopCommandServiceImpl();

    @Test
    void execute() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/display-shop-discounts.jsp"));

        String id = "1";
        when(request.getParameter(any(String.class))).thenReturn(id);
        assertEquals(id, request.getParameter(PARAM_ID));

        new ShopDiscountsCommand().execute(request, response);
        verify(requestDispatcher).forward(request, response);

        Shop shop = shopCommandService.getById(Shop.class, Integer.parseInt(id));
        List<?> listDiscountShops = CriteriaSearchUtil.joinTablesShopDiscounts(Integer.parseInt(id));
        verify(request).setAttribute(ATTR_SHOP, shop);
        verify(request).setAttribute(ATTR_LIST_DISCOUNT_SHOPS, listDiscountShops);

        verify(request, atLeast(1)).getParameter(PARAM_ID);
    }
}
