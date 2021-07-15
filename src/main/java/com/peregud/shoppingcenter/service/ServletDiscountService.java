package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.model.Discount;

import java.util.List;

public class ServletDiscountService extends ServletService<Discount> {

    public Discount save(Discount discount) {
        return super.save(discount);
    }

    public Discount getById(int id) {
        return super.getById(Discount.class, id);
    }

    public List<?> getList() {
        return super.getAll(Discount.class);
    }

    public void delete(int id) {
        super.delete(Discount.class, id);
    }

    public void deleteList(String[] idList) {
        super.deleteList(Discount.class, idList);
    }
}
