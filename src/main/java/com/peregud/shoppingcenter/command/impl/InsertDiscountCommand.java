package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.command.util.CommandRedirectUtil;
import com.peregud.shoppingcenter.converter.ConverterProvider;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.DiscountCommandService;
import com.peregud.shoppingcenter.service.impl.DiscountCommandServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.peregud.shoppingcenter.command.CommandType.*;

public class InsertDiscountCommand implements Command {
    private final DiscountCommandService discountCommandService = new DiscountCommandServiceImpl();

    @SneakyThrows
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Discount discount = ConverterProvider.convert(Discount.class, request);
        discountCommandService.save(discount);
        response.sendRedirect(CommandRedirectUtil.page(LIST_SHOPS));
    }
}
