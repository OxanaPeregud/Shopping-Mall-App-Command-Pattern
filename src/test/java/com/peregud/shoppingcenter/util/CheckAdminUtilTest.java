package com.peregud.shoppingcenter.util;

import com.peregud.shoppingcenter.GenerateDataForH2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckAdminUtilTest extends GenerateDataForH2 {

    @Test
    void findAdmin() {
        assertTrue(CheckAdminUtil.findAdmin("admin", "1234"));
    }
}
