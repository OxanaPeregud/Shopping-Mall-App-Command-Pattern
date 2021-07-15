package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.service.ServletShopService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DeleteListShopsServlet implements Command {
    private final ServletShopService servletShopService = new ServletShopService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        servletShopService.deleteList(request.getParameterValues(PARAM_DELETE_SHOP));
        List<?> listShops = servletShopService.getList();
        request.setAttribute(ATTR_LIST_SHOPS, listShops);
        request.getRequestDispatcher("view/shops-list.jsp").forward(request, response);
    }
}
