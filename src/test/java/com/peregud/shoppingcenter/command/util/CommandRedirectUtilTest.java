package com.peregud.shoppingcenter.command.util;

import org.junit.jupiter.api.Test;

import static com.peregud.shoppingcenter.command.CommandType.LIST_SHOPS;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandRedirectUtilTest {

    @Test
    void page() {
        assertEquals("controller?command=list_shops", CommandRedirectUtil.page(LIST_SHOPS));
    }
}
