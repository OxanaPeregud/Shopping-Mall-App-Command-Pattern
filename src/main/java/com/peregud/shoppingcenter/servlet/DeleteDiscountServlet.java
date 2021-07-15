package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.service.ServletDiscountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DeleteDiscountServlet implements Command {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        servletDiscountService.delete(id);
        response.sendRedirect("controller?command=list_discounts");
    }
}
