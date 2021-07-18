package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.util.CriteriaSearchUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

public class DisplayDiscountStatisticsCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<?> listStatistics = CriteriaSearchUtil.discountStatistics();
        request.setAttribute(ATTR_LIST_STATISTICS, listStatistics);
        request.getRequestDispatcher("view/display-statistics.jsp").forward(request, response);
    }
}
