package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.model.Discount;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public Set<Discount> getSet(List<Integer> discountIdList) {
        Integer i;
        Set<Discount> set = new HashSet<>();
        for (Integer id : discountIdList) {
            i = id;
            Discount discount = super.getById(Discount.class, i);
            set.add(discount);
        }
        return set;
    }
}
