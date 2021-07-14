package com.peregud.shoppingcenter.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

class ServletAdminServiceTest {

    @BeforeEach
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Mock
    ServletAdminService servletAdminService;

    @Test
    void findAdmin_success() {
        when(servletAdminService.findAdmin("name", "password")).thenReturn(true);
        assertTrue(servletAdminService.findAdmin("name", "password"));
    }

    @Test
    void findAdmin_fail() {
        when(servletAdminService.findAdmin("name", "password")).thenReturn(true);
        assertFalse(servletAdminService.findAdmin("admin", "password"));
    }
}
