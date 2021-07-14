package com.peregud.shoppingcenter.converter;

import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.model.Shop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConverterImplTest {

    @Test
    void getConverter_success() throws Exception {
        assertEquals(ConverterImpl.getSHOP_CONVERTER(), ConverterImpl.getConverter(Shop.class));
    }

    @Test
    void getConverter_fail() throws Exception {
        assertNotEquals(ConverterImpl.getSHOP_CONVERTER(), ConverterImpl.getConverter(Discount.class));
    }
}
