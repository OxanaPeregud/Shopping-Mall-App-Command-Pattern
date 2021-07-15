package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ServletShopService;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class SetDiscountServlet implements Command {
    private final ServletShopService servletShopService = new ServletShopService();

    @SneakyThrows
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        Shop shop = servletShopService.getById(id);
        request.setAttribute(ATTR_SHOP, shop);
        request.getRequestDispatcher("view/discount-form.jsp").forward(request, response);
    }
}
