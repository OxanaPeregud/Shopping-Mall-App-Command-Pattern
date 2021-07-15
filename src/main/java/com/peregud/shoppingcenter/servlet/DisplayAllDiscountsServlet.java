package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.service.ServletDiscountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DisplayAllDiscountsServlet implements Command {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<?> listDiscounts = servletDiscountService.getList();
        request.setAttribute(ATTR_LIST_DISCOUNTS, listDiscounts);
        request.getRequestDispatcher("view/display-discounts.jsp").forward(request, response);
    }
}
