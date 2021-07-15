package com.peregud.shoppingcenter.servlet;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.util.CriteriaSearchUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class ShopsActualDiscountsServlet implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<?> listActualDiscounts = CriteriaSearchUtil.joinTablesActualDiscounts();
        request.setAttribute(ATTR_LIST_DISCOUNT_SHOPS, listActualDiscounts);
        request.getRequestDispatcher("view/display-discount-shops.jsp").forward(request, response);
    }
}
