package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletDiscountService;
import com.peregud.shoppingcenter.service.ServletShopService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit-discount")
public class EditDiscountServlet extends HttpServlet {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();
    private final ServletShopService servletShopService = new ServletShopService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Discount discount = servletDiscountService.getById(id);
        request.setAttribute("discount", discount);
        Shop shop = servletShopService.getById(id);
        request.setAttribute("shop", shop);
        request.getRequestDispatcher("view/edit-discount-form.jsp").forward(request, response);
    }
}
