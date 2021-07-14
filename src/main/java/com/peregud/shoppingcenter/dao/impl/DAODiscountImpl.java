package com.peregud.shoppingcenter.dao.impl;

import com.peregud.shoppingcenter.dao.AbstractDAO;
import com.peregud.shoppingcenter.dao.DAODiscount;
import com.peregud.shoppingcenter.model.Discount;

import java.util.List;

public class DAODiscountImpl extends AbstractDAO<Discount> implements DAODiscount {

    @Override
    public Discount save(Discount discount) {
        return super.save(discount);
    }

    @Override
    public Discount getById(Class<Discount> clazz, int id) {
        return super.getById(clazz, id);
    }

    @Override
    public void delete(Class<Discount> clazz, int id) {
        super.delete(clazz, id);
    }

    @Override
    public List<?> getAll(Class<Discount> clazz) {
        return super.getAll(clazz);
    }
}
