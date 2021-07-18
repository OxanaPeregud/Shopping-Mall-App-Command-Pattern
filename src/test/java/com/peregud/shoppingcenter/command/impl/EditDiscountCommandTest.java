package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.MockInit;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.DiscountCommandService;
import com.peregud.shoppingcenter.service.ShopCommandService;
import com.peregud.shoppingcenter.service.impl.DiscountCommandServiceImpl;
import com.peregud.shoppingcenter.service.impl.ShopCommandServiceImpl;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EditDiscountCommandTest extends MockInit {
    DiscountCommandService discountCommandService = new DiscountCommandServiceImpl();
    ShopCommandService shopCommandService = new ShopCommandServiceImpl();

    @Test
    void execute() throws ServletException, IOException {
        when(request.getRequestDispatcher(any(String.class))).thenReturn(requestDispatcher);
        assertEquals(requestDispatcher, request.getRequestDispatcher("view/edit-discount-form.jsp"));

        String id = "1";
        when(request.getParameter(any(String.class))).thenReturn(id);
        assertEquals(id, request.getParameter(PARAM_ID));

        new EditDiscountCommand().execute(request, response);
        verify(requestDispatcher).forward(request, response);

        Discount discount = discountCommandService.getById(Discount.class, Integer.parseInt(id));
        verify(request).setAttribute(ATTR_DISCOUNT, discount);

        Shop shop = shopCommandService.getById(Shop.class, Integer.parseInt(id));
        verify(request).setAttribute(ATTR_SHOP, shop);

        verify(request, atLeast(1)).getParameter(PARAM_ID);
    }
}
