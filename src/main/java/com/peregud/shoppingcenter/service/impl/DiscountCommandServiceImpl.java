package com.peregud.shoppingcenter.service.impl;

import com.peregud.shoppingcenter.dao.AbstractDAO;
import com.peregud.shoppingcenter.model.Discount;
import com.peregud.shoppingcenter.service.DiscountCommandService;

import java.util.List;

public class DiscountCommandServiceImpl extends AbstractDAO<Discount> implements DiscountCommandService {

    @Override
    public Discount save(Discount discount) {
        return super.save(discount);
    }

    @Override
    public Discount getById(Class<Discount> clazz, int id) {
        return super.getById(clazz, id);
    }

    @Override
    public List<Discount> getList(Class<Discount> clazz) {
        return super.getAll(clazz);
    }

    @Override
    public void delete(Class<Discount> clazz, int id) {
        super.delete(clazz, id);
    }

    @Override
    public void deleteList(Class<Discount> clazz, String[] idList) {
        String i;
        for (String id : idList) {
            i = id;
            super.delete(clazz, Integer.parseInt(i));
        }
    }
}
