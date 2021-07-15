package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.converter.impl.ConverterImpl;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.ServletDiscountService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InsertDiscountServlet implements Command {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();

    @SneakyThrows
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Discount discount = ConverterImpl.convert(Discount.class, request);
        servletDiscountService.save(discount);
        response.sendRedirect("controller?command=list_shops");
    }
}
