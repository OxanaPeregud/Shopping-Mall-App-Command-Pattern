package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletDiscountService;
import com.peregud.shoppingcenter.service.ServletShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class EditDiscountCommand implements Command {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();
    private final ServletShopService servletShopService = new ServletShopService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        Discount discount = servletDiscountService.getById(id);
        request.setAttribute(ATTR_DISCOUNT, discount);
        Shop shop = servletShopService.getById(id);
        request.setAttribute(ATTR_SHOP, shop);
        request.getRequestDispatcher("view/edit-discount-form.jsp").forward(request, response);
    }
}
