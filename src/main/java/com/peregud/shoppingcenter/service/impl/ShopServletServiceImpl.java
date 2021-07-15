package com.peregud.shoppingcenter.service.impl;

import com.peregud.shoppingcenter.dao.AbstractDAO;
import com.peregud.shoppingcenter.model.Shop;
import com.peregud.shoppingcenter.service.ShopServletService;

import java.util.List;

public class ShopServletServiceImpl extends AbstractDAO<Shop> implements ShopServletService {

    @Override
    public Shop save(Shop shop) {
        return super.save(shop);
    }

    @Override
    public Shop getById(Class<Shop> clazz, int id) {
        return super.getById(clazz, id);
    }

    @Override
    public List<Shop> getList(Class<Shop> clazz) {
        return super.getAll(clazz);
    }

    @Override
    public void delete(Class<Shop> clazz, int id) {
        super.delete(clazz, id);
    }

    @Override
    public void deleteList(Class<Shop> clazz, String[] idList) {
        String i;
        for (String id : idList) {
            i = id;
            super.delete(clazz, Integer.parseInt(i));
        }
    }
}
