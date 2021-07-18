package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.util.CriteriaSearchUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class SearchDiscountCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int minimumDiscount = Integer.parseInt(request.getParameter(PARAM_MIN_DISCOUNT));
        List<?> listDiscountShops = CriteriaSearchUtil.joinTablesMinimumDiscount(minimumDiscount);
        request.setAttribute(ATTR_MIN_DISCOUNT, minimumDiscount);
        request.setAttribute(ATTR_LIST_DISCOUNT_SHOPS, listDiscountShops);
        request.getRequestDispatcher("view/display-discount-shops.jsp").forward(request, response);
    }
}
