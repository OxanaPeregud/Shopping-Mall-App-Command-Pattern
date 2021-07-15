package com.peregud.shoppingcenter.command.impl;

import com.peregud.shoppingcenter.command.Command;
import com.peregud.shoppingcenter.command.CommandType;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.peregud.shoppingcenter.command.CommandType.*;

public class CommandImpl {
    private static final Map<CommandType, Command> COMMANDS;

    static {
        COMMANDS = new HashMap<>();
        COMMANDS.put(CHOOSE_LOCALE, new ChooseLocaleCommand());
        COMMANDS.put(MAP, new MapCommand());
        COMMANDS.put(CONTACT, new ContactCommand());
        COMMANDS.put(ADMIN_LOGIN, new AdminLoginCommand());
        COMMANDS.put(DELETE_DISCOUNT, new DeleteDiscountCommand());
        COMMANDS.put(DELETE_SHOP, new DeleteShopCommand());
        COMMANDS.put(DISPLAY_SHOPS, new DisplayAllShopsCommand());
        COMMANDS.put(DISPLAY_DISCOUNTS, new DisplayAllDiscountsCommand());
        COMMANDS.put(DISCOUNT_STATISTICS, new DisplayDiscountStatisticsCommand());
        COMMANDS.put(EDIT_DISCOUNT, new EditDiscountCommand());
        COMMANDS.put(EDIT_SHOP, new EditShopCommand());
        COMMANDS.put(INFO_DISCOUNT, new InfoDiscountCommand());
        COMMANDS.put(INFO_SHOP, new InfoShopCommand());
        COMMANDS.put(LOGIN, new LoginCommand());
        COMMANDS.put(LOGOUT, new LogoutCommand());
        COMMANDS.put(NEW_SHOP, new NewShopCommand());
        COMMANDS.put(SEARCH_DISCOUNT, new SearchDiscountCommand());
        COMMANDS.put(SEARCH_SHOP, new SearchShopCommand());
        COMMANDS.put(SET_DISCOUNT, new SetDiscountCommand());
        COMMANDS.put(SHOP_DISCOUNTS, new ShopDiscountsCommand());
        COMMANDS.put(SHOP_ACTUAL_DISCOUNTS, new ShopsActualDiscountsCommand());
        COMMANDS.put(UPDATE_DISCOUNT, new UpdateDiscountCommand());
        COMMANDS.put(UPDATE_SHOP, new UpdateShopCommand());
        COMMANDS.put(LIST_DISCOUNTS, new ListDiscountsCommand());
        COMMANDS.put(DELETE_LIST_DISCOUNTS, new DeleteListDiscountsCommand());
        COMMANDS.put(LIST_SHOPS, new ListShopsCommand());
        COMMANDS.put(DELETE_LIST_SHOPS, new DeleteListShopsCommand());
        COMMANDS.put(INSERT_DISCOUNT, new InsertDiscountCommand());
        COMMANDS.put(INSERT_SHOP, new InsertShopCommand());
    }

    public static Command getCommand(String name) throws Exception {
        return Optional.ofNullable(COMMANDS.get(CommandType.valueOf(name.toUpperCase()))).orElseThrow(Exception::new);
    }
}
