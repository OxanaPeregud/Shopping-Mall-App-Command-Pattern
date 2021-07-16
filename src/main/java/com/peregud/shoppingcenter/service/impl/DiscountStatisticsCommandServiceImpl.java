package com.peregud.shoppingcenter.service.impl;

import com.peregud.shoppingcenter.dao.AbstractDAO;
import com.peregud.shoppingcenter.model.DiscountStatistics;

import java.util.List;

public class DiscountStatisticsCommandServiceImpl extends AbstractDAO<DiscountStatistics>
        implements DiscountStatisticsCommandService {

    @Override
    public DiscountStatistics save(DiscountStatistics discountStatistics) {
        return super.save(discountStatistics);
    }

    @Override
    public DiscountStatistics getById(Class<DiscountStatistics> clazz, int id) {
        return super.getById(clazz, id);
    }

    @Override
    public List<DiscountStatistics> getList(Class<DiscountStatistics> clazz) {
        return super.getAll(clazz);
    }

    @Override
    public void delete(Class<DiscountStatistics> clazz, int id) {
        super.delete(clazz, id);
    }

    @Override
    public void deleteList(Class<DiscountStatistics> clazz, String[] idList) {
        String i;
        for (String id : idList) {
            i = id;
            super.delete(clazz, Integer.parseInt(i));
        }
    }
}
