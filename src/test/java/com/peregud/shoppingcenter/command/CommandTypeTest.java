package com.peregud.shoppingcenter.command;

import org.junit.jupiter.api.Test;

import static com.peregud.shoppingcenter.command.CommandType.LIST_SHOPS;
import static org.junit.jupiter.api.Assertions.*;

class CommandTypeTest {

    @Test
    void getCommandType() {
        assertEquals(LIST_SHOPS, CommandType.getCommandType("LIST_SHOPS"));
    }
}
