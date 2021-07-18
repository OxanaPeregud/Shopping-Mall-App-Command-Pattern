package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.DiscountCommandService;
import com.peregud.shoppingcenter.service.ShopCommandService;
import com.peregud.shoppingcenter.service.impl.DiscountCommandServiceImpl;
import com.peregud.shoppingcenter.service.impl.ShopCommandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class EditDiscountCommand implements Command {
    private final DiscountCommandService discountCommandService = new DiscountCommandServiceImpl();
    private final ShopCommandService shopCommandService = new ShopCommandServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        Discount discount = discountCommandService.getById(Discount.class, id);
        request.setAttribute(ATTR_DISCOUNT, discount);
        Shop shop = shopCommandService.getById(Shop.class, id);
        request.setAttribute(ATTR_SHOP, shop);
        request.getRequestDispatcher("view/edit-discount-form.jsp").forward(request, response);
    }
}
