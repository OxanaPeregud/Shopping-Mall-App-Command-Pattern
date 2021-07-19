package com.peregud.shoppingcenter.listener;

import com.peregud.shoppingcenter.util.DiscountListenerUtil;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;

import static com.peregud.shoppingcenter.command.CommandConstant.*;

@WebListener
public class DiscountListener implements ServletRequestAttributeListener {

    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        Object attributeValue = servletRequestAttributeEvent.getValue();
        String attributeName = servletRequestAttributeEvent.getName();
        if (StringUtils.isNotBlank(ATTR_MIN_DISCOUNT) && ATTR_MIN_DISCOUNT.equals(attributeName)) {
            DiscountListenerUtil.save(attributeValue.toString());
        }
    }
}
