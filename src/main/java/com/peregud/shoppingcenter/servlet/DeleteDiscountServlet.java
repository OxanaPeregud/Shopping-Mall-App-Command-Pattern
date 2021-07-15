package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.service.ServletDiscountService;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebServlet("/delete-discount")
public class DeleteDiscountServlet extends HttpServlet {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        servletDiscountService.delete(id);
        response.sendRedirect(request.getContextPath() + "/list-discounts");
    }
}
