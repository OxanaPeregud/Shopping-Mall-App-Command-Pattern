package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.command.CommandType;
import com.peregud.shoppingcenter.servlet.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.peregud.shoppingcenter.command.CommandType.*;

public class CommandImpl {
    private static final Map<CommandType, Command> COMMANDS;

    static {
        COMMANDS = new HashMap<>();
        COMMANDS.put(CHOOSE_LOCALE, new ChooseLocaleServlet());
        COMMANDS.put(MAP, new MapServlet());
        COMMANDS.put(CONTACT, new ContactServlet());
        COMMANDS.put(ADMIN_LOGIN, new AdminLoginServlet());
        COMMANDS.put(DELETE_DISCOUNT, new DeleteDiscountServlet());
        COMMANDS.put(DELETE_SHOP, new DeleteShopServlet());
        COMMANDS.put(DISPLAY_SHOPS, new DisplayAllShopsServlet());
        COMMANDS.put(DISPLAY_DISCOUNTS, new DisplayAllDiscountsServlet());
        COMMANDS.put(DISCOUNT_STATISTICS, new DisplayDiscountStatisticsServlet());
        COMMANDS.put(EDIT_DISCOUNT, new EditDiscountServlet());
        COMMANDS.put(EDIT_SHOP, new EditShopServlet());
        COMMANDS.put(INFO_DISCOUNT, new InfoDiscountServlet());
        COMMANDS.put(INFO_SHOP, new InfoShopServlet());
        COMMANDS.put(LOGIN, new LoginServlet());
        COMMANDS.put(LOGOUT, new LogoutServlet());
        COMMANDS.put(NEW_SHOP, new NewShopServlet());
        COMMANDS.put(SEARCH_DISCOUNT, new SearchDiscountServlet());
        COMMANDS.put(SEARCH_SHOP, new SearchShopServlet());
        COMMANDS.put(SET_DISCOUNT, new SetDiscountServlet());
        COMMANDS.put(SHOP_DISCOUNTS, new ShopDiscountsServlet());
        COMMANDS.put(SHOP_ACTUAL_DISCOUNTS, new ShopsActualDiscountsServlet());
        COMMANDS.put(UPDATE_DISCOUNT, new UpdateDiscountServlet());
        COMMANDS.put(UPDATE_SHOP, new UpdateShopServlet());
        COMMANDS.put(LIST_DISCOUNTS, new ListDiscountsServlet());
        COMMANDS.put(DELETE_LIST_DISCOUNTS, new DeleteListDiscountsServlet());
        COMMANDS.put(LIST_SHOPS, new ListShopsServlet());
        COMMANDS.put(DELETE_LIST_SHOPS, new DeleteListShopsServlet());
        COMMANDS.put(INSERT_DISCOUNT, new InsertDiscountServlet());
        COMMANDS.put(INSERT_SHOP, new InsertShopServlet());
    }

    public static Command getCommand(String name) throws Exception {
        return Optional.ofNullable(COMMANDS.get(CommandType.valueOf(name))).orElseThrow(Exception::new);
    }
}
