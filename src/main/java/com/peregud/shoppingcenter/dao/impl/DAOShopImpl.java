package com.peregud.shoppingcenter.dao.impl;

import com.peregud.shoppingcenter.dao.AbstractDAO;
import com.peregud.shoppingcenter.dao.DAOShop;
import com.peregud.shoppingcenter.model.Shop;

import java.util.List;

public class DAOShopImpl extends AbstractDAO<Shop> implements DAOShop {

    @Override
    public Shop save(Shop shop) {
        return super.save(shop);
    }

    @Override
    public Shop getById(Class<Shop> clazz, int id) {
        return super.getById(clazz, id);
    }

    @Override
    public void delete(Class<Shop> clazz, int id) {
        super.delete(clazz, id);
    }

    @Override
    public List<?> getAll(Class<Shop> clazz) {
        return super.getAll(clazz);
    }
}
