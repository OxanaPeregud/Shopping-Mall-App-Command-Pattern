package com.peregud.shoppingcenter.listener;

import com.peregud.shoppingcenter.service.DiscountListenerService;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebListener
public class DiscountListener implements ServletRequestAttributeListener {
    private final DiscountListenerService discountListenerService = new DiscountListenerService();

    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String attributeName = servletRequestAttributeEvent.getName();
        Object attributeValue = servletRequestAttributeEvent.getValue();
        if (attributeName.equals(ATTR_MIN_DISCOUNT)) {
            discountListenerService.save(attributeValue.toString());
        }
    }
}
