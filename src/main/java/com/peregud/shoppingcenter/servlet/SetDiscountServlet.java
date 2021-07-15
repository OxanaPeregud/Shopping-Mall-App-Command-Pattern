package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletShopService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebServlet("/set-discount")
public class SetDiscountServlet extends HttpServlet {
    private final ServletShopService servletShopService = new ServletShopService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        Shop shop = servletShopService.getById(id);
        request.setAttribute(ATTR_SHOP, shop);
        request.getRequestDispatcher("view/discount-form.jsp").forward(request, response);
    }
}
