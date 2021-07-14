package com.peregud.shoppingcenter.service;

import com.peregud.shoppingcenter.model.Shop;

import java.util.List;

public class ServletShopService extends ServletService<Shop> {
    private final ServletDiscountService servletDiscountService = new ServletDiscountService();

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

    @SuppressWarnings("unchecked")
    public void set(Shop shop, int id) {
        getById(id).setDiscount(servletDiscountService.getSet((List<Integer>) selectIdForSet(shop, id)));
    }

    public List<?> selectIdForSet(Shop shop, int id) {
        return super.selectIdForSet(shop, id);
    }
}
