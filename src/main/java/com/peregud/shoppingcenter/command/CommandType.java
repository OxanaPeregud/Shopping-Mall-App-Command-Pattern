package com.peregud.shoppingcenter.command;

public enum CommandType {
    CHOOSE_LOCALE,
    MAP,
    DISPLAY_SHOPS,
    CONTACT,
    ADMIN_LOGIN,
    DISPLAY_DISCOUNTS,
    DISCOUNT_STATISTICS,
    EDIT_DISCOUNT,
    EDIT_SHOP,
    INFO_DISCOUNT,
    INFO_SHOP,
    LOGIN,
    LOGOUT,
    NEW_SHOP,
    SEARCH_DISCOUNT,
    SEARCH_SHOP,
    SET_DISCOUNT,
    SHOP_DISCOUNTS,
    SHOP_ACTUAL_DISCOUNTS,
    UPDATE_DISCOUNT,
    UPDATE_SHOP,
    LIST_DISCOUNTS,
    DELETE_LIST_DISCOUNTS,
    LIST_SHOPS,
    DELETE_LIST_SHOPS,
    INSERT_DISCOUNT,
    INSERT_SHOP,
    PAGINATED_LIST;

    public static CommandType getCommandType(String name) {
        return CommandType.valueOf(name.toUpperCase());
    }
}
