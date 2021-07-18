package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.DiscountCommandService;
import com.peregud.shoppingcenter.service.impl.DiscountCommandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DisplayAllDiscountsCommand implements Command {
    private final DiscountCommandService discountCommandService = new DiscountCommandServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<?> listDiscounts = discountCommandService.getList(Discount.class);
        request.setAttribute(ATTR_LIST_DISCOUNTS, listDiscounts);
        request.getRequestDispatcher("view/display-discounts.jsp").forward(request, response);
    }
}
