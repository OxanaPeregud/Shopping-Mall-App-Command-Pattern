package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.converter.ConverterImpl;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.ServletDiscountService;
import lombok.SneakyThrows;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/insert-discount-to-shop")
public class InsertDiscountToShopServlet extends HttpServlet {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        Discount discount = ConverterImpl.convert(Discount.class, request);
        servletDiscountService.save(discount);
        response.sendRedirect(request.getContextPath() + "/list-shops");
    }
}
