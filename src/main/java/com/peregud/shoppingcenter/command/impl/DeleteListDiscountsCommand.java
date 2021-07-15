package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.DiscountServletService;
import com.peregud.shoppingcenter.service.impl.DiscountServletServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DeleteListDiscountsCommand implements Command {
    private final DiscountServletService discountServletService = new DiscountServletServiceImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        discountServletService.deleteList(Discount.class, request.getParameterValues(PARAM_DELETE_DISCOUNT));
        List<?> listDiscounts = discountServletService.getList(Discount.class);
        request.setAttribute(ATTR_LIST_DISCOUNTS, listDiscounts);
        request.getRequestDispatcher("view/discounts-list.jsp").forward(request, response);
    }
}
