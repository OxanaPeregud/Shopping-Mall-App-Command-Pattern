package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.ServletDiscountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class InfoDiscountServlet implements Command {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        Discount discount = servletDiscountService.getById(id);
        request.setAttribute(ATTR_DISCOUNT, discount);
        request.getRequestDispatcher("view/discount-information.jsp").forward(request, response);
    }
}
