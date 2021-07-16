package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.DiscountCommandService;
import com.peregud.shoppingcenter.service.impl.DiscountCommandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class InfoDiscountCommand implements Command {
    private final DiscountCommandService discountCommandService = new DiscountCommandServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        Discount discount = discountCommandService.getById(Discount.class, id);
        request.setAttribute(ATTR_DISCOUNT, discount);
        request.getRequestDispatcher("view/discount-information.jsp").forward(request, response);
    }
}
