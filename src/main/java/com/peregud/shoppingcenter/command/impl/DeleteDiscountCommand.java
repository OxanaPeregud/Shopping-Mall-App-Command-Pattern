package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.DiscountServletService;
import com.peregud.shoppingcenter.service.impl.DiscountServletServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DeleteDiscountCommand implements Command {
    private final DiscountServletService discountServletService = new DiscountServletServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        discountServletService.delete(Discount.class, id);
        response.sendRedirect("controller?command=list_discounts");
    }
}
