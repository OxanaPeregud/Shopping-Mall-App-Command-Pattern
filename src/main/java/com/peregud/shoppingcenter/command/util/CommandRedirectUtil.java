package com.peregud.shoppingcenter.command.util;

import com.peregud.shoppingcenter.command.CommandType;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CommandRedirectUtil {

    public String page(CommandType commandType) {
        return "controller?command=" + String.valueOf(commandType).toLowerCase();
    }
}
