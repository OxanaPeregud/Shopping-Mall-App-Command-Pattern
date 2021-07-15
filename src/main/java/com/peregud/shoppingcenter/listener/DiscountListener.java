package com.peregud.shoppingcenter.listener;

import com.peregud.shoppingcenter.util.DiscountListenerUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebListener
public class DiscountListener implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        Object attributeValue = servletRequestAttributeEvent.getValue();
        String attributeName = servletRequestAttributeEvent.getName();
        if (attributeName != null && attributeName.equals(ATTR_MIN_DISCOUNT)) {
            DiscountListenerUtil.save(attributeValue.toString());
        }
    }
}
