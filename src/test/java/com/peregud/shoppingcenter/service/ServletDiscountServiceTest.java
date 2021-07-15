package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.util.CheckAdminUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class ServletDiscountServiceTest {

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    CheckAdminUtil checkAdminUtil;

    @Test
    void findAdmin_success() {
        when(checkAdminUtil.findAdmin("name", "password")).thenReturn(true);
        assertTrue(checkAdminUtil.findAdmin("name", "password"));
    }

    @Test
    void findAdmin_fail() {
        when(checkAdminUtil.findAdmin("name", "password")).thenReturn(true);
        assertFalse(checkAdminUtil.findAdmin("admin", "password"));
    }
}
