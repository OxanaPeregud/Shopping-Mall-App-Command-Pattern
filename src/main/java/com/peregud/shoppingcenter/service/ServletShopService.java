package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.model.Shop;

import java.util.List;

public class ServletShopService extends ServletService<Shop> {

    public Shop save(Shop shop) {
        return super.save(shop);
    }

    public Shop getById(int id) {
        return super.getById(Shop.class, id);
    }

    public List<?> getList() {
        return super.getAll(Shop.class);
    }

    public void delete(int id) {
        super.delete(Shop.class, id);
    }

    public void deleteList(String[] idList) {
        super.deleteList(Shop.class, idList);
    }
}
