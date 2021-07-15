package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.service.ServletShopService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DeleteShopCommand implements Command {
    private final ServletShopService servletShopService = new ServletShopService();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter(PARAM_ID));
        servletShopService.delete(id);
        response.sendRedirect("controller?command=list_shops");
    }
}
